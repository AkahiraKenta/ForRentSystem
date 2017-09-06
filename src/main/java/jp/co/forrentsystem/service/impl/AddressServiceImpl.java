package jp.co.forrentsystem.service.impl;

import java.util.List;

import jp.co.forrentsystem.dao.AddressDao;
import jp.co.forrentsystem.dao.PopularityAreaDao;
import jp.co.forrentsystem.dao.impl.AddressImportHistoryDao;
import jp.co.forrentsystem.dto.AddressDto;
import jp.co.forrentsystem.service.AddressService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 住所サービス実装クラス
 * @author k.akhaira
 *
 */
@Service
 public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;
	@Autowired
	private AddressImportHistoryDao addressImportHistoryDao;
	@Autowired
	private PopularityAreaDao popularityAreaDao;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(AddressServiceImpl.class);

//	/** 削除住所CSVファイル名固定文言 */
//	private final static String DEL = "DEL";
//	/** 追加住所CSVファイル名固定文言 */
//	private final static String ADD = "ADD";

	// TODO:住所マスタ登録を止めているためコメントアウト

//	@Override
//	public AddressImportHistoryDto getAddressImportHistoryToMaxYears() {
//		logger.info("AddressServiceImpl-getAddressImportHistoryToMaxYears");
//		// 住所取込マスタ情報取得
//		return addressImportHistoryDao.getAddressImportHistoryToMaxYears();
//	}
//
//	@Override
//	public Map<String,List<AddressDto>> getAddressListForRegist(
//			AddressImportHistoryDto addressImportHistoryDto) throws IOException {
//		logger.info("AddressServiceImpl-getAddressListForRegist");
//		// TODO:住所取込マスタ情報の"対象年""対象月"を引数に与える。一旦仮値
//		// 処理対象住所取得
//		Map<String, List<String[]>> splitAddressValuesMap = getTargetAddress(addressImportHistoryDto, ADD);
//
//		List<AddressDto> addressDtoList = new ArrayList<AddressDto>();
//		Map<String, List<AddressDto>> addressDtoMap = new HashMap<String, List<AddressDto>>();
//		for (String key : splitAddressValuesMap.keySet()) {
//			for (String[] splitAddressValues : splitAddressValuesMap.get(key)) {
//				// 各項目をDTOへセット
//				AddressDto addressDto = new AddressDto();
//				setAddressDto(addressDto, splitAddressValues);
//
//				addressDtoList.add(addressDto);
//				addressDtoMap.put(key, addressDtoList);
//			}
//		}
//
//
//
//		return addressDtoMap;
//	}
//
//	@Override
//	public Map<String,List<AddressDto>> getAddressListForDelete(
//			AddressImportHistoryDto addressImportHistoryDto) throws IOException {
//		// 処理対象住所取得
//		Map<String, List<String[]>> splitAddressValuesMap = getTargetAddress(addressImportHistoryDto, DEL);
//
//		List<AddressDto> addressDtoList = new ArrayList<AddressDto>();
//		Map<String, List<AddressDto>> addressDtoMap = new HashMap<String, List<AddressDto>>();
//		for (String key : splitAddressValuesMap.keySet()) {
//			for (String[] splitAddressValues : splitAddressValuesMap.get(key)) {
//				// 各項目をDTOへセット
//				AddressDto addressDto = new AddressDto();
//				setAddressDto(addressDto, splitAddressValues);
//
//				addressDtoList.add(addressDto);
//				addressDtoMap.put(key, addressDtoList);
//			}
//		}
//		return addressDtoMap;
//	}
//
//	@Override
//	public boolean registAddressImportHistroty(Map<String, List<AddressDto>> targetYearsMap) {
//		for (String key : targetYearsMap.keySet()) {
//			String targetYear = key.substring(0, 2);
//			String targetMonth = key.substring(2, 4);
//			AddressImportHistoryDto addressImportHistoryDto = new AddressImportHistoryDto();
//			// 対象年
//
//			// 対象月
//
//
//			addressImportHistoryDao.insert(addressImportHistoryDto);
//		}
//
//		return true;
//	}
//
//	@Override
//	public boolean registAddress(Map<String, List<AddressDto>> addressDtoListForRegistMap) {
//		for (String key : addressDtoListForRegistMap.keySet()) {
//			for (AddressDto addressDto : addressDtoListForRegistMap.get(key)) {
//				// 住所マスタ管理へ登録
//				addressDao.insertAddress(addressDto);
//			}
//		}
//		return true;
//	}
//
//	@Override
//	public boolean deleteAddress(Map<String, List<AddressDto>> addressDtoListForDeleteMap) {
//		for (String key : addressDtoListForDeleteMap.keySet()) {
//			for (AddressDto addressDto : addressDtoListForDeleteMap.get(key)) {
//				// 住所マスタ管理へ削除
//				addressDao.deleteAddress(addressDto);
//			}
//		}
//		return true;
//	}
//
	@Override
	public List<AddressDto> getAddressListViewByZipCode(String zipCode) {
		logger.info("AddressServiceImpl-getAddressViewList");
		List<AddressDto> addressDtoList = addressDao.getAddressListViewByZipCode(zipCode);
//		 List<AddressDto> addressDtoList = addressDao.getAddressListByZipCode(zipCode);
		return addressDtoList;
//		return null;
	}


	@Override
	public AddressDto getZipCode(String province, String city, String town) {
		logger.info("AddressServiceImpl-getZipCode");
		AddressDto addressDto = new AddressDto();
		addressDto.setProvince(province);
		addressDto.setCity(city);
		addressDto.setTown(town);

		return addressDao.getZipCode(addressDto);
	}
//
//	/**
//	 * 住所マスタ管理DTOへ値をセット
//	 * @param splitAddressValues 住所マスタ管理情報（項目毎）
//	 *
//	 * @return 住所マスタ管理DTO
//	 * @throws IOException ファイル読み込みエラー
//	 */
//	private AddressDto setAddressDto(AddressDto addressDto, String[] splitAddressValues) throws IOException {
//			// 全国地方公共団体コード
//
//			// （旧）郵便番号（5桁）
//
//			// 郵便番号（7桁）
//
//			// 都道府県名(半角カタカナ)
//
//			// 市区町村名(半角カタカナ)
//
//			// 町域名(半角カタカナ)
//
//			// 都道府県名(漢字)
//
//			// 市区町村名(漢字)
//
//			// 町域名(漢字)
//
//			// 一町域が二以上の郵便番号で表される場合の表示（「1」は該当、「0」は該当せず）
//
//			// 小字毎に番地が起番されている町域の表示（「1」は該当、「0」は該当せず）
//
//			// 丁目を有する町域の場合の表示（「1」は該当、「0」は該当せず）
//
//			// 一つの郵便番号で二以上の町域を表す場合の表示（「1」は該当、「0」は該当せず）
//
//			// 更新の表示（「0」は変更なし、「1」は変更あり、「2」廃止（廃止データのみ使用））
//
//			// 変更理由（「0」は変更なし、「1」市政・区政・町政・分区・政令指定都市施行、「2」住居表示の実施、「3」区画整理、「4」郵便区調整等、「5」訂正、「6」廃止（廃止データのみ使用））
//
//		return addressDto;
//	}

//	/**
//	 * 処理対象住所取得
//	 * @param addressImportHistoryDto 取込済年月(YYMM)
//	 * @param key 追加or削除判別文字列
//	 *
//	 * @return 対象住所情報(項目毎)
//	 * @throws IOException プロパティファイル読込エラー
//	 */
//	private Map<String,List<String[]>> getTargetAddress(AddressImportHistoryDto addressImportHistoryDto,
//			String key) throws IOException {
//		String addressFilePath = this.getProperyValue("addressInfo.properties", "address_file_path");
//		File dir = new File(addressFilePath);
//		File[] files = dir.listFiles();
//		Map<String, List<String[]>> splitAddressValuesMap = new HashMap<String, List<String[]>>();
//		List<String[]> splitAddressValuesList = new ArrayList<String[]>();
//		for(File file : files) {
//			if (!file.getName().startsWith(key)) {
//				// 対象外ファイルの場合
//				continue;
//			}
//			if(!checkFile(file, addressImportHistoryDto)) {
//				// ファイルチェックエラーの場合
//				continue;
//			}
//			BufferedReader br = new BufferedReader(new FileReader(file));
//			String record;
//			while((record = br.readLine()) != null){
//				// 文字列分解
//				String[] recordSplit = record.split(",");
//
//				splitAddressValuesList.add(recordSplit);
//			}
//			br.close();
//			// 年月取得
//			String targetFileYYMM = file.getName().substring(5, 8);
//			splitAddressValuesMap.put(targetFileYYMM, splitAddressValuesList);
//		}
//		return splitAddressValuesMap;
//		return null;
//	}

//	/**
//	 * 対象郵政住所ファイル取得
//	 * @param beforeImportYears 取込済年月(YYMM)
//	 * @param key 追加or削除判別文字列
//	 *
//	 * @return 対象住所情報(項目毎)
//	 * @throws IOException プロパティファイル読込エラー
//	 */
//	private List<String[]> getTargetAddressFile(int beforeImportYears, String key) throws IOException {
//		String addressFilePath = this.getProperyValue("addressInfo.properties", "address_file_path");
//		File dir = new File(addressFilePath);
//		File[] files = dir.listFiles();
//		List<String[]> splitAddressValuesList = new ArrayList<String[]>();
//		for(File file : files) {
//			if (!file.getName().startsWith(key)) {
//				// 対象外ファイルの場合
//				continue;
//			}
//			if(!checkFile(file, beforeImportYears)) {
//				// ファイルチェックエラーの場合
//				continue;
//			}
//			BufferedReader br = new BufferedReader(new FileReader(file));
//			String record;
//			while((record = br.readLine()) != null){
//				// 文字列分解
//				String[] recordSplit = record.split(",");
//
//				splitAddressValuesList.add(recordSplit);
//			}
//			br.close();
//		}
//		return splitAddressValuesList;
//	}
//
//	/**
//	 * プロパティ値取得
//	 *
//	 * @param propertyFileName プロパティファイル名
//	 * @param propertyKey プロパティキー値
//	 *
//	 * @return プロパティ値
//	 * @throws IOException
//	 */
//	private String getProperyValue(String propertyFileName, String propertyKey) throws IOException {
//		Properties properties = new Properties();
//		// 対象プロパティファイル取得
//		InputStream is = this.getClass().getResourceAsStream(
//				String.format("/%s", propertyFileName));
//		// 文字コード指定し読取
//		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
//		BufferedReader br = new BufferedReader(isr);
//		properties.load(br);
//		String propertiesValue = properties.getProperty(propertyKey);
//		br.close();
//		isr.close();
//		is.close();
//		// 対象プロパティ値取得
//		return propertiesValue;
//	}
//
//	/**
//	 * ファイルチェック
//	 * @param beforeImportYears 取り込み済ファイル年月（最大値）
//	 * @param file ファイル
//	 */
//	private boolean checkFile(File file, int beforeImportYears) {
//		if (!CsvUtil.checkFile(file)) {
//			return false;
//		} else {
//			Pattern addPpattern = Pattern.compile("ADD_.*\\.CSV");
//			Pattern delPattern = Pattern.compile("DEL_.*\\.CSV");
//			if(!addPpattern.matcher(file.getName()).find()
//					&& !delPattern.matcher(file.getName()).find()) {
//				// 2つのファイルフォーマットに合わない場合
//				return false;
//			}
//		}
//		// 年月取得
//		String targetFileYears = file.getName().substring(5, 8);
//		// 取り込み対象年月かチェック
//		if (beforeImportYears >= Integer.parseInt(targetFileYears)) {
//			// 取り込み済年月以下の場合
//			return false;
//		}
//		return true;
//	}

}
