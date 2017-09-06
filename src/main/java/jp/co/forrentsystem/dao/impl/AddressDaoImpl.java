package jp.co.forrentsystem.dao.impl;

import java.util.List;

import jp.co.forrentsystem.dao.AddressDao;
import jp.co.forrentsystem.dto.AddressDto;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * 住所マスタDAO実装クラス
 * @author k.akahira
 *
 */

@Repository
public class AddressDaoImpl extends SqlSessionDaoSupport implements AddressDao {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(AddressDaoImpl.class);

	@Override
	public void insertAddress(AddressDto addressDto) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void deleteAddress(AddressDto addressDto) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public List<AddressDto> getAddressListViewByZipCode(String zipCode) {
		logger.info("AddressDaoImpl-getAddressListViewByZipCode");
		return getSqlSession().selectList("getAddressListViewByZipCode", zipCode);
	}

	@Override
	public List<AddressDto> getProvinceListForPopularityArea() {
		logger.info("AddressDaoImpl-getProvinceListForPopularityArea");
		return getSqlSession().selectList("getProvinceListForPopularityArea");
	}

	@Override
	public List<AddressDto> getAddressListForPopularityAreaByProvince(
			String province) {
		logger.info("AddressDaoImpl-getAddressListForPopularityAreaByProvince");
		return getSqlSession().selectList("getAddressListForPopularityAreaByProvince", province);
	}

	@Override
	public AddressDto getZipCode(AddressDto addressDto) {
		logger.info("AddressDaoImpl-getZipCode");
		return getSqlSession().selectOne("getZipCode", addressDto);
	}
}
