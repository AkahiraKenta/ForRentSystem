package jp.co.forrentsystem.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jp.co.forrentsystem.dao.BuildingContactDetailDao;
import jp.co.forrentsystem.dao.BuildingContactHeaderDao;
import jp.co.forrentsystem.dao.SystemUserDao;
import jp.co.forrentsystem.dto.BuildingContactDto;
import jp.co.forrentsystem.form.backend.BuildingContactForm;
import jp.co.forrentsystem.form.frontend.FContactArticleForm;
import jp.co.forrentsystem.service.BuildingContactService;
import jp.co.forrentsystem.service.RoomsService;
import jp.co.forrentsystem.util.FileUtil;
import jp.co.forrentsystem.util.MailUtil;
import jp.co.forrentsystem.util.PagerUtil;

/**
 * 物件お問合せサービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class BuildingContactServiceImpl implements BuildingContactService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(BuildingContactServiceImpl.class);

	@Autowired
	private RoomsService roomsService;
	@Autowired
	private BuildingContactDetailDao buildingContactDetailDao;
	@Autowired
	private BuildingContactHeaderDao buildingContactHeaderDao;
	@Autowired
	private SystemUserDao systemUserDao;

	@Override
	public void registBuildingContact(FContactArticleForm fContactArticleForm) throws Exception {
		logger.info("BuildingContactServiceImpl-registBuildingContact");

		BuildingContactDto buildingContactDto = new BuildingContactDto();
		buildingContactDto.setBuildingId(fContactArticleForm.getBuildingId());
		buildingContactDto.setRoomId(fContactArticleForm.getRoomId());
		buildingContactDto.setProcessStatus(1);
		buildingContactDto.setProcessClass(fContactArticleForm.getProcessClass());
		buildingContactDto.setLastName(fContactArticleForm.getLastName());
		buildingContactDto.setFirstName(fContactArticleForm.getFirstName());
		buildingContactDto.setMailAddress(fContactArticleForm.getMailAddress());
		buildingContactDto.setTel(fContactArticleForm.getTel());
		buildingContactDto.setResidentsHopeTime(fContactArticleForm.getResidentsHopeTime());
		buildingContactDto.setContactContent(fContactArticleForm.getContactContent());


		// メール送信
		// 物件お問合せ明細登録
		buildingContactDetailDao.registBuildingContactDetail(buildingContactDto);

		// 物件お問合せのお問合せIDを取得
		int buildingContactId = buildingContactDetailDao.getBuildingContactId();

		// DTOにお問合せIDを設定
		buildingContactDto.setBuildingContactId(buildingContactId);

		// 物件お問合せヘッダー登録
		buildingContactHeaderDao.registBuildingContactHeader(buildingContactDto);

		// 物件詳細情報取得（メール本文に使用）
//		ArticleDto articleDto = roomsService.getDetailArticle(buildingContactDto.getBuildingId(), buildingContactDto.getRoomId());

		// メール送信情報を設定
		String message = this.getMessage(buildingContactDto);

		// お客様へメール送信
		MailUtil.sendMailFotHtml("物件お問合せ内容確認", message, buildingContactDto.getMailAddress(), MailUtil.getMailAddress(), "", null);

		// 担当者へメール送信
		MailUtil.sendMailFotHtml("物件お問合せ情報", message, MailUtil.getMailAddress(), buildingContactDto.getMailAddress(), "", null);
	}

	/**
	 * メールメッセージを設定
	 *
	 * @param buildingContactDto 物件お問合せ情報
	 * @return
	 */
	private String getMessage(BuildingContactDto buildingContactDto) {
		StringBuffer sb = new StringBuffer();
		sb.append("お問合せID：")
		.append(String.valueOf(buildingContactDto.getBuildingContactId()))
		.append(MailUtil.NEW_LINE)
		.append("建物ID：")
		.append("")
		.append(MailUtil.NEW_LINE)
		.append("建物名称：")
		.append("")
		.append(MailUtil.NEW_LINE)
		.append("部屋ID：")
		.append("")
		.append(MailUtil.NEW_LINE)
		.append("部屋名称：")
		.append("")
		.append(MailUtil.NEW_LINE)
		.append("お問合せ種類：")
		.append("")
		.append(MailUtil.NEW_LINE)
		.append("お客様氏名（姓）：")
		.append("")
		.append(MailUtil.NEW_LINE)
		.append("お客様氏名（名）：")
		.append("")
		.append(MailUtil.NEW_LINE)
		.append("お客様メールアドレス：")
		.append("")
		.append(MailUtil.NEW_LINE)
		.append("電話番号：")
		.append("")
		.append(MailUtil.NEW_LINE)
		.append("その他ご希望など：")
		.append("")
		.append(MailUtil.NEW_LINE);
		return sb.toString();
	}

	@Override
	public List<BuildingContactDto> getNewBuildingContact() {
		logger.info("BuildingContactServiceImpl-getNewBuildingContact");

		// 物件問い合わせ取得
		return buildingContactDetailDao.getNewBuildingContact();
	}

	@Override
	public List<BuildingContactDto> getBuildingContactList(BuildingContactForm  buildingContactForm) {
		logger.info("BuildingContactServiceImpl-getBuildingContact");

		BuildingContactDto buildingContactDto = new BuildingContactDto();
		buildingContactDto.setProcessStatus(buildingContactForm.getSearchProcessStatus());
		buildingContactDto.setViewNumber(buildingContactForm.getViewNumber());
		buildingContactDto.setFromNumber(PagerUtil.getNumberFrom(buildingContactForm.getCurrentPage(), buildingContactForm.getViewNumber()));

		// 物件問い合わせ取得
		return buildingContactDetailDao.getBuildingContactList(buildingContactDto);
	}

	@Override
	public List<BuildingContactDto> getBuildingContactByContactId(
			Integer buildingContactId) {
		logger.info("BuildingContactServiceImpl-getBuildingContactByContactId");

		return buildingContactDetailDao.getBuildingContactByContactId(buildingContactId);
	}

	@Override
	public void updateBuildingContactForProcessStatus(
			Integer buildingContactId, Integer processStatus) {
		logger.info("BuildingContactServiceImpl-updateBuildingContactForProcessStatus");

		BuildingContactDto buildingContactDto = new BuildingContactDto();
		buildingContactDto.setBuildingContactId(buildingContactId);
		buildingContactDto.setProcessStatus(processStatus);

		buildingContactDetailDao.updateBuildingContactForProcessStatus(buildingContactDto);

	}

	@Override
	public BuildingContactForm getPagerInfo(BuildingContactForm buildingContactForm) {
		logger.info("BuildingContactServiceImpl-getPagerInfo");

		// 対象件数
		int totalNumber = buildingContactDetailDao.getBuildingContactCount(buildingContactForm.getProcessStatus());
		// 表示件数
		int viewNumber = FileUtil.getContactViewNumber();
		buildingContactForm.setViewNumber(viewNumber);
		buildingContactForm.setTotalNumber(totalNumber);

		// 全ページ数
		buildingContactForm.setPageTotalNumber(PagerUtil.getPageTotalNumber(totalNumber, viewNumber));
		return buildingContactForm;
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
