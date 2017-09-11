package jp.co.forrentsystem.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jp.co.forrentsystem.dao.BuildingContactHeaderDao;
import jp.co.forrentsystem.dao.ContactDao;
import jp.co.forrentsystem.dao.SystemUserDao;
import jp.co.forrentsystem.dto.ContactDto;
import jp.co.forrentsystem.form.backend.ContactForm;
import jp.co.forrentsystem.form.frontend.FContactForm;
import jp.co.forrentsystem.service.ContactService;
import jp.co.forrentsystem.service.RoomsService;
import jp.co.forrentsystem.util.FileUtil;
import jp.co.forrentsystem.util.MailUtil;
import jp.co.forrentsystem.util.PagerUtil;

/**
 * お問合せサービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class ContactServiceImpl implements ContactService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(ContactServiceImpl.class);

	@Autowired
	private RoomsService roomsService;
	@Autowired
	private ContactDao contactDao;
	@Autowired
	private BuildingContactHeaderDao buildingContactHeaderDao;
	@Autowired
	private SystemUserDao systemUserDao;

	@Override
	public void registContact(FContactForm fContactForm) throws Exception {
		logger.info("ContactServiceImpl-registContact");

		ContactDto contactDto = new ContactDto();
		contactDto.setProcessStatus(1);
		contactDto.setLastName(fContactForm.getLastName());
		contactDto.setFirstName(fContactForm.getFirstName());
		contactDto.setCompanyName(fContactForm.getCompanyName());
		contactDto.setMailAddress(fContactForm.getMailAddress());
		contactDto.setTel(fContactForm.getTel());
		contactDto.setContactContent(fContactForm.getContactContent());


		// メール送信
		// お問合せ明細登録
		contactDao.registContact(contactDto);

		// お問合せのお問合せIDを取得
		int contactId = contactDao.getContactId();

		// DTOにお問合せIDを設定
		contactDto.setContactId(contactId);


		// メール送信情報を設定
		String message = this.getMessage(contactDto);

		// お客様へメール送信
		MailUtil.sendMailFotHtml("お問合せ内容確認", message, contactDto.getMailAddress(), MailUtil.getMailAddress(), "", null);

		// 担当者へメール送信
		MailUtil.sendMailFotHtml("お問合せ情報", message, MailUtil.getMailAddress(), contactDto.getMailAddress(), "", null);
	}

	/**
	 * メールメッセージを設定
	 *
	 * @param buildingContactDto お問合せ情報
	 * @return
	 */
	private String getMessage(ContactDto contactDto) {
		StringBuffer sb = new StringBuffer();
		sb.append("お問合せID：")
		.append(String.valueOf(contactDto.getContactId()))
		.append(MailUtil.NEW_LINE)
		.append("お客様氏名（姓）：")
		.append("")
		.append(MailUtil.NEW_LINE)
		.append("お客様氏名（名）：")
		.append("")
		.append(MailUtil.NEW_LINE)
		.append("会社名：")
		.append("")
		.append(MailUtil.NEW_LINE)
		.append("お客様メールアドレス：")
		.append("")
		.append(MailUtil.NEW_LINE)
		.append("お問い合せ内容：")
		.append("")
		.append(MailUtil.NEW_LINE);
		return sb.toString();
	}

	@Override
	public ContactForm getPagerInfo(ContactForm contactForm) {
		logger.info("BuildingContactServiceImpl-getPagerInfo");

		// 対象件数
		int totalNumber = contactDao.getContactCount(contactForm.getProcessStatus());
		// 表示件数
		int viewNumber = FileUtil.getContactViewNumber();
		contactForm.setViewNumber(viewNumber);
		contactForm.setTotalNumber(totalNumber);

		// 全ページ数
		contactForm.setPageTotalNumber(PagerUtil.getPageTotalNumber(totalNumber, viewNumber));
		return contactForm;
	}

	@Override
	public List<ContactDto> getContactList(ContactForm contactForm) {
		logger.info("ContactServiceImpl-getContactList");

		ContactDto contactDto = new ContactDto();
		contactDto.setProcessStatus(contactForm.getSearchProcessStatus());
		contactDto.setViewNumber(contactForm.getViewNumber());
		contactDto.setFromNumber(PagerUtil.getNumberFrom(contactForm.getCurrentPage(), contactForm.getViewNumber()));

		// 物件問い合わせ取得
		return contactDao.getContactList(contactDto);
	}

	@Override
	public List<ContactDto> getContactByContactId(int contactId) {
		logger.info("ContactServiceImpl-getContactByContactId");

		return contactDao.getContactByContactId(contactId);
	}

	@Override
	public void updateContactForProcessStatus(Integer contactId,
			Integer processStatus) {
		logger.info("ContactServiceImpl-updateContactForProcessStatus");

		ContactDto contactDto = new ContactDto();
		contactDto.setContactId(contactId);
		contactDto.setProcessStatus(processStatus);

		contactDao.updateContactForProcessStatus(contactDto);
	}

	@Override
	public ModelMap reloadModel(ModelMap model, HttpSession session) {
		if (model.isEmpty() == false) {
			session.setAttribute("model", model);
		} else {
			model = (ModelMap)session.getAttribute("model");
		}
		return model;
	}
}
