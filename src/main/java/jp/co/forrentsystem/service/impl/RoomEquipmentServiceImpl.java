package jp.co.forrentsystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import jp.co.forrentsystem.constants.Constants;
import jp.co.forrentsystem.constants.MasterDto;
import jp.co.forrentsystem.dao.RoomEquipmentDao;
import jp.co.forrentsystem.dto.RoomEquipmentDto;
import jp.co.forrentsystem.service.RoomEquipmentService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 部屋設備サービス実装クラス
 * @author k.akhaira
 *
 */
@Service
public class RoomEquipmentServiceImpl implements RoomEquipmentService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(RoomEquipmentServiceImpl.class);

	@Autowired
	private RoomEquipmentDao roomEquipmentDao;

	@Override
	public List<RoomEquipmentDto> getRoomEquipmentList(Integer buildingId, Integer roomId,
			String[] equipmentArray, List<MasterDto> equipmentList) {
		logger.info("RoomEquipmentServiceImpl-getRoomEquipmentList");

		List<RoomEquipmentDto> roomEquipmentDtoList = new ArrayList<RoomEquipmentDto>();

		// 選択された部屋設備IDをDTOリストに設定
		for (String equipmentId : equipmentArray) {
			for (MasterDto equipment : equipmentList) {
				if (Integer.parseInt(equipmentId) == equipment.getId()) {
					RoomEquipmentDto roomEquipmentDto = new RoomEquipmentDto();
					roomEquipmentDto.setBuildingId(buildingId);
					roomEquipmentDto.setRoomId(roomId);
					roomEquipmentDto.setEquipmentId(equipment.getId());
					roomEquipmentDto.setDeleteFlag(Constants.DELETE_FLAG_FALSE);
					roomEquipmentDtoList.add(roomEquipmentDto);
				}
			}
		}
		return roomEquipmentDtoList;
	}

	@Override
	public void registRoomEquipment(List<RoomEquipmentDto> roomEquipmentDtoList) {
		logger.info("RoomEquipmentServiceImpl-registRoomEquipment");

		// 部屋設備情報を登録
		for(RoomEquipmentDto roomEquipmentDto : roomEquipmentDtoList) {
			roomEquipmentDao.registRoomEquipment(roomEquipmentDto);
		}
	}

	@Override
	public List<Integer> getRoomEquipmentIdList(Integer buildingId, Integer roomId) {
		logger.info("RoomEquipmentServiceImpl-getRoomEquipmentListBybuildingIdAndRoomId");

		// 部屋設備情報を設定
		RoomEquipmentDto roomEquipmentDto = new RoomEquipmentDto();
		roomEquipmentDto.setBuildingId(buildingId);
		roomEquipmentDto.setRoomId(roomId);

		// 部屋設備情報のIDを返却
		return roomEquipmentDao.getRoomEquipmentIdList(roomEquipmentDto);
	}

	@Override
	public void updateRoomEquipment(List<RoomEquipmentDto> roomEquipmentDtoList) {
		logger.info("RoomEquipmentServiceImpl-updateRoomEquipment");
		// 現在設定データを削除する。
		roomEquipmentDao.deleteRoomEquipment(roomEquipmentDtoList.get(0));

		// 部屋設備情報を登録する
		for(RoomEquipmentDto roomEquipmentDto : roomEquipmentDtoList) {
			roomEquipmentDao.registRoomEquipment(roomEquipmentDto);
		}

	}
}
