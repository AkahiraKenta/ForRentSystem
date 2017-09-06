package jp.co.forrentsystem.controller.backend;

import java.io.File;
import java.io.IOException;

import jp.co.forrentsystem.constants.LinkClass;
import jp.co.forrentsystem.dto.HdFtDto;
import jp.co.forrentsystem.service.HdFtService;
import jp.co.forrentsystem.util.FileUtil;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * ヘッダーフッターコントローラ
 * @author k.akahira
 */
@Controller
public class HdFtController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(HdFtController.class);

	@Autowired
	private HdFtService hdFtService;

	/**
	 * ヘッダーフッターマスタ初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/back/hdFt", method = RequestMethod.GET)
	public ModelAndView execute() {
		logger.info("HdFtController-execute");

		// ヘッダーフッター情報取得
		HdFtDto hdFt = hdFtService.getHdFt();

		ModelAndView mav = new ModelAndView();
		mav.addObject("hdFt", hdFt);
		mav.addObject("linkClassList", LinkClass.getLinkClassList());
		mav.setViewName("./back/hdFtBaseSetting");

		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/back/back/editHdFt", method = RequestMethod.POST)
    public HdFtDto updateHdFt(@Param(value="id") Integer id,
    					   @RequestParam("headerUpload") MultipartFile headerFile,
    					   @RequestParam("footerUpload") MultipartFile footerFile,
    					   @Param(value="companyName") String companyName,
    					   @Param(value="tel") String tel,
    					   @Param(value="fax") String fax,
    					   @Param(value="mailAddress") String mailAddress,
    					   @Param(value="transitionUrl") String transitionUrl,
    					   @Param(value="transitionFlag") Integer transitionFlag,
    					   Model model) throws IOException {

		logger.info("HdFtController-updateHdFt");

		//==================================================================
		// アップロード処理
		//==================================================================
//		if (file.isEmpty() ) {
//			// ファイル内空の場合
//
//		}
//
		// アップロードベースディレクトリ
		String baseDirectoryName = FileUtil.getFileBaseDirectory();
		String delimiter = FileUtil.getDirectoryDelimiter();

		// ヘッダー情報
		String headerPath = FileUtil.getHeaderPath();
		String headerDirectoryPath = baseDirectoryName + headerPath + delimiter;
		String headerFileName = headerFile.getOriginalFilename();

		// フッター情報
		String footerPath = FileUtil.getFooterPath();
		String footerDirectoryPath = baseDirectoryName + footerPath + delimiter;
		String footerFileName = footerFile.getOriginalFilename();

		try {
			headerFile.transferTo(new File(headerDirectoryPath + headerFileName));
			footerFile.transferTo(new File(footerDirectoryPath + footerFileName));
		} catch (IOException e) {
			// ファイルアップロードエラー処理
			throw e;
		}


		//==================================================================
		// DB更新 建物画像テーブルにInsert
		//==================================================================
		HdFtDto hdFtDto = hdFtService.updateHdFt(id, headerFileName, footerFileName,
				companyName, tel, fax, mailAddress, transitionUrl, transitionFlag);

		return hdFtDto;

	}
}
