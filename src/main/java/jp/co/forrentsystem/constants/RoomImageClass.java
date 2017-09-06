package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 部屋画像区分の共通定数クラス
 * @author webridge
 *
 */
public enum RoomImageClass {
    /** 列挙定数の定義 */
	ROOM_IMAGE_CLASS_FLOOR_PLAN("間取図", 1),
	ROOM_IMAGE_CLASS_INTROSPECTION("内観", 2),
	ROOM_IMAGE_CLASS_BALCONY("バルコニー", 3),
	ROOM_IMAGE_CLASS_OTHER("その他", 4);

    /** フィールド変数 */
    private String name;
    private int value;

    /** コンストラクタ */
    RoomImageClass(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /** 名称取得メソッド */
    public String getName() {
        return this.name;
    }

    /** 値取得メソッド */
    public int getValue() {
        return this.value;
    }

    /**
     * 部屋画像区分名称の取得
     *
     * @param value 部屋画像区分値
     *
     * @return 部屋画像区分名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (RoomImageClass roomImageClass : RoomImageClass.values()) {
            if (roomImageClass.getValue() == value) {
                name = roomImageClass.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * 部屋画像区分選択項目リストの設定
     *
     * @return 部屋画像区分選択項目リスト
     */
    public static List<MasterDto> getRoomImageClassList() {
    	List<MasterDto> roomImageClassList = new ArrayList<MasterDto>();
    	for (RoomImageClass roomImageClass : RoomImageClass.values()) {
    		MasterDto roomImageClassDto = new MasterDto();
    		roomImageClassDto.setId(roomImageClass.getValue() );
    		roomImageClassDto.setName(roomImageClass.getName());
    		roomImageClassList.add(roomImageClassDto);
    	}
    	return roomImageClassList;
    }
}