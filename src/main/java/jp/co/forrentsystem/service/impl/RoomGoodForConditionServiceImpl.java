package jp.co.forrentsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.dao.RoomGoodForConditionDao;
import jp.co.forrentsystem.dto.RoomGoodForConditionDto;
import jp.co.forrentsystem.service.RoomGoodForConditionService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * こだわり条件実装クラス
 * @author k.akhaira
 *
 */
@Service
public class RoomGoodForConditionServiceImpl implements RoomGoodForConditionService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RoomGoodForConditionServiceImpl.class);

	@Autowired
	private RoomGoodForConditionDao roomGoodForConditionDao;

	@Override
	public List<RoomGoodForConditionDto> getRoomGoodForConditionList(Integer buildingId, Integer roomId,
			String[] goodForConditionArray, List<MasterDto> goodForConditionList) {
		logger.info("RoomEquipmentServiceImpl-getRoomEquipmentList");

		List<RoomGoodForConditionDto> roomGoodForConditionDtoList = new ArrayList<RoomGoodForConditionDto>();

		// 選択された部屋こだわり条件をDTOリストに設定する
		for (String conditionId : goodForConditionArray) {
			for (MasterDto goodForCondition : goodForConditionList) {
				if (Integer.parseInt(conditionId) == goodForCondition.getId()) {
					RoomGoodForConditionDto roomGoodForConditionDto = new RoomGoodForConditionDto();
					roomGoodForConditionDto.setBuildingId(buildingId);
					roomGoodForConditionDto.setRoomId(roomId);
					roomGoodForConditionDto.setConditionId(goodForCondition.getId());
					roomGoodForConditionDtoList.add(roomGoodForConditionDto);
				}
			}
		}
		return roomGoodForConditionDtoList;
	}

	@Override
	public void registRoomGoodForCondition(List<RoomGoodForConditionDto> roomGoodForConditionDtoList) {
		logger.info("RoomEquipmentServiceImpl-registRoomEquipment");

		// 選択された部屋こだわり条件を登録する
		for(RoomGoodForConditionDto roomGoodForConditionDto : roomGoodForConditionDtoList) {
			roomGoodForConditionDao.registRoomGoodForCondition(roomGoodForConditionDto);
		}
	}

	@Override
	public List<Integer> getRoomGoodForConditionIdList(Integer buildingId,
			Integer roomId) {
		logger.info("RoomGoodForConditionServiceImpl-getRoomGoodForConditionIdList");

		// 部屋こだわり条件取得条件をDTOに設定
		RoomGoodForConditionDto roomGoodForConditionDto = new RoomGoodForConditionDto();
		roomGoodForConditionDto.setBuildingId(buildingId);
		roomGoodForConditionDto.setRoomId(roomId);

		// 対象の部屋こだわり条件を取得
		return roomGoodForConditionDao.getRoomGoodForConditionIdList(roomGoodForConditionDto);
	}

	@Override
	public void updateRoomGoodForCondition(
			List<RoomGoodForConditionDto> roomGoodForConditionDtoList) {
		logger.info("RoomEquipmentServiceImpl-updateRoomGoodForCondition");

		// 選択された部屋こだわり条件を削除する。
		roomGoodForConditionDao.deleteRoomGoodForCondition(roomGoodForConditionDtoList.get(0));
		for(RoomGoodForConditionDto roomGoodForConditionDto : roomGoodForConditionDtoList) {
			roomGoodForConditionDao.registRoomGoodForCondition(roomGoodForConditionDto);
		}
	}
}
