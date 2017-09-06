package jp.co.forrentsystem.controller.backend;

import java.util.List;

import jp.co.forrentsystem.dto.StructureDto;
import jp.co.forrentsystem.service.StructureService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 構造一覧コントローラ
 * @author k.akahira
 */
@Controller
public class ListStructureController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(ListStructureController.class);

	@Autowired
	private StructureService structureService;

	/**
	 * 構造マスタ初期表示
	 *
	 * @return 画面表示情報
	 */
	@RequestMapping(value = "/back/listStructure", method = RequestMethod.GET)
	public ModelAndView execute() {
		logger.info("ListStructureController-execute");

		// 構造情報取得
		List<StructureDto> structureList = structureService.getStructureList();

		ModelAndView mav = new ModelAndView();
		mav.addObject("structureList", structureList);
		mav.setViewName("./back/structure");

		return mav;
	}

	/**
	 * 構造マスタ登録処理
	 *
	 * @return 構造マスタ情報
	 */
	@ResponseBody
	@RequestMapping(value = "/back/registStructure", method = RequestMethod.POST)
	public StructureDto registStructure() {
		logger.info("ListStructureController-registStructure");

		// 構造マスタ登録
		StructureDto structureDto = structureService.registStructure();

		return structureDto;
	}

	/**
	 * 構造マスタ削除処理
	 *
	 * @param structureId 構造マスタID
	 *
	 * @return 削除対象構造マスタID
	 */
	@ResponseBody
	@RequestMapping(value = "/back/deleteStructure", method = RequestMethod.GET)
	public Integer deleteStructure(@Param(value="structureId") Integer structureId) {
		logger.info("ListStructureController-deleteStructure");

		// 構造マスタ削除
		int deletestructureId = structureService.deleteStructure(structureId);

		return deletestructureId;
	}

	/**
	 * 構造マスタの名称を更新
	 *
	 * @param structureId 構造マスタID
	 * @param structureName 構造マスタ名称
	 *
	 * @return 構造マスタDTO
	 */
	@ResponseBody
	@RequestMapping(value = "/back/updateStructure", method = RequestMethod.GET)
	public StructureDto updateStructure(@Param(value="structureId") Integer structureId
			, @Param(value="structureName") String structureName) {
		logger.info("ListStructureController-updateStructure");

		// 構造マスタ更新
		StructureDto structureDto = structureService.updateStructure(structureId, structureName);

		return structureDto;
	}
}
