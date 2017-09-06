package jp.co.forrentsystem.constants;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * システムユーザー区分定数クラス
 * @author d.kitajima
 *
 */
public enum SystemUserClass {

	//ADMINISTRATOR("管理者", 1),
	COMMON_USER("システム利用者", 3);
//	PARSON("担当者", 3);


	private String name;
	private int value;

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	/**
	 * コンストラクタ
	 * @param name
	 * @param value
	 */
	private SystemUserClass(String name, int value) {
		this.name = name;
		this.value = value;
	}

	 /**
     * システムユーザー区分のIDを取得
     *
     * @param name システムユーザー区分名称
     *
     * @return システムユーザー区分数値
     */
    public static Integer getTargetId(String name) {
    	int value = 0;
    	for (SystemUserClass systemUserClass : SystemUserClass.values()) {
            if (StringUtils.equals(systemUserClass.getName(), name)) {
            	value = systemUserClass.getValue();
                break;
            }
        }
    	return value;
    }

    /**
     * システムユーザー区分の名称を取得
     *
     * @param value システムユーザー区分数値
     *
     * @return システムユーザー区分名称
     */
    public static String getTargetName(int value) {
    	String name = null;
    	for (SystemUserClass systemUserClass : SystemUserClass.values()) {
            if (systemUserClass.getValue() == value) {
                name = systemUserClass.getName();
                break;
            }
        }
    	return name;
    }

    /**
     * システムユーザー区分の選択項目リストの設定
     *
     * @return システムユーザー区分の選択項目リスト
     */
    public static List<MasterDto> getSystemUserClassList() {
    	List<MasterDto> systemSettingList = new ArrayList<MasterDto>();
    	for (SystemUserClass systemUserClass : SystemUserClass.values()) {
    		MasterDto systemSettingDto = new MasterDto();
    		systemSettingDto.setId(systemUserClass.getValue() );
    		systemSettingDto.setName(systemUserClass.getName());
    		systemSettingList.add(systemSettingDto);
    	}
    	return systemSettingList;
    }
}
