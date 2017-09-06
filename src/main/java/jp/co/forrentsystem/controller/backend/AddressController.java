package jp.co.forrentsystem.controller.backend;

import jp.co.forrentsystem.dto.AddressDto;
import jp.co.forrentsystem.service.AddressService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//TODO:作成途中（一旦作業止めている状態）
/**
 * 住所マスタ管理コントローラ
 * @author k.akahira
 */
@Controller
public class AddressController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(AddressController.class);

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/back/address", method = RequestMethod.GET)
	public ModelAndView execute() {
		logger.info("AddressController-execute");

		ModelAndView mav = new ModelAndView();

		mav.setViewName("./back/addressMasterManage");

		return mav;
	}

	@RequestMapping(value = "/back/updateAddressManage", method = RequestMethod.POST)
	public ModelAndView updateAddressManage() {
		logger.info("AddressController-updateAddressManage");

//		// 住所取込履歴情報取得
//		AddressImportHistoryDto addressImportHistoryDto = addressService.getAddressImportHistoryToMaxYears();
//
//		try {
//
//			// 削除する住所管理情報取得
//			Map<String, List<AddressDto>> addressDtoListForDeleteMap =
//					addressService.getAddressListForDelete(addressImportHistoryDto);
//
//			// 追加する住所管理情報取得
//			Map<String, List<AddressDto>> addressDtoListForRegistMap =
//					addressService.getAddressListForRegist(addressImportHistoryDto);
//
//
//			// 住所管理情報削除
//			addressService.deleteAddress(addressDtoListForDeleteMap);
//
//			// 住所管理情報登録
//			addressService.registAddress(addressDtoListForRegistMap);
//
//			// 住所取込情報登録
//			addressService.registAddressImportHistroty(addressDtoListForDeleteMap);
//		} catch (IOException e) {
//			// エラー
//			e.printStackTrace();
//		}

		ModelAndView mav = new ModelAndView();

		return mav;
	}

	/**
	 * 郵便番号検索画面表示用
	 *
	 * @return 画面遷移先
	 */
	@RequestMapping(value = "/back/callSearchZip", method = RequestMethod.GET)
	public String callSearchZip() {
		logger.info("AddressController-callSearchZip");

		return "/back/searchZip";
	}



	/**
	 * 郵便番号検索
	 *
	 * @param province 都道府県
	 * @param city 市区町村
	 * @param townArea 町域
	 * @return 住所DTO
	 */
	@ResponseBody
	@RequestMapping(value = "/back/searchZip", method = RequestMethod.GET)
	public AddressDto searchZip(@Param(value="province") String province,
								@Param(value="city") String city,
								@Param(value="townArea") String town) {
		logger.info("AddressController-searchZip");

		// 郵便番号取得
		AddressDto addressDto = addressService.getZipCode(province, city, town);

		return addressDto;
	}
}
