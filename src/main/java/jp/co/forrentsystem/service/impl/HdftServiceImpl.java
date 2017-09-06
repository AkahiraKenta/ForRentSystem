package jp.co.forrentsystem.service.impl;

import jp.co.forrentsystem.dao.HdFtDao;
import jp.co.forrentsystem.dto.HdFtDto;
import jp.co.forrentsystem.service.HdFtService;
import jp.co.forrentsystem.util.FileUtil;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ヘッダーフッターサービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class HdftServiceImpl implements HdFtService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(HdftServiceImpl.class);

	@Autowired
	private HdFtDao hdFtDao;

	@Override
	public HdFtDto getHdFt() {
		logger.info("HdftServiceImpl-getHdFt");

		// ヘッダーフッター情報を取得
		return hdFtDao.getHdFt();
	}

	@Override
	public HdFtDto updateHdFt(Integer id, String headerFileName, String footerFileName,
			String companyName, String tel, String fax, String mailAddress,
			String transitionUrl, Integer transitionFlag) {
		logger.info("HdftServiceImpl-updateHdFt");

		// ヘッダーフッター情報をDTOに設定
		HdFtDto hdFtDto = new HdFtDto();
		hdFtDto.setId(id);
		hdFtDto.setHeaderFileName(headerFileName);
		hdFtDto.setHeaderFilePath(FileUtil.getFileRelativePath()+FileUtil.getHeaderPath()+FileUtil.getDirectoryDelimiter());
		hdFtDto.setFooterFileName(footerFileName);
		hdFtDto.setFooterFilePath(FileUtil.getFileRelativePath()+FileUtil.getFooterPath()+FileUtil.getDirectoryDelimiter());
		hdFtDto.setCompanyName(companyName);
		hdFtDto.setTel(tel);
		hdFtDto.setFax(fax);
		hdFtDto.setMailAddress(mailAddress);
		hdFtDto.setTransitionUrl(transitionUrl);
		hdFtDto.setTransitionFlag(transitionFlag);

		// ヘッダーフッター情報を更新
		hdFtDao.updateHdFt(hdFtDto);
		return hdFtDto;
	}
}
