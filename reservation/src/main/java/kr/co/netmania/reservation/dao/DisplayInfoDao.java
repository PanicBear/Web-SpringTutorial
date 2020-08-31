package kr.co.netmania.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.netmania.reservation.dto.DisplayImage;
import kr.co.netmania.reservation.dto.DisplayInfo;
import kr.co.netmania.reservation.dto.DisplayInfoImage;
import kr.co.netmania.reservation.dto.DisplayPrice;

@Repository
public class DisplayInfoDao {
	public NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfo> rowMapperDisplayInfo = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
	private RowMapper<DisplayImage> rowMapperDisplayImage = BeanPropertyRowMapper.newInstance(DisplayImage.class);
	private RowMapper<DisplayInfoImage> rowMapperDisplayInfoImage = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
	private RowMapper<DisplayPrice> rowMapperDisplayPrice = BeanPropertyRowMapper.newInstance(DisplayPrice.class);

	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	
	// api/displayinfos
	// parameter : categoryId, start
	public List<DisplayInfo> selectProducts(Integer categoryId, Integer start) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("categoryId", categoryId);
		if (categoryId >= 1) {
			return jdbc.query(DisplayInfoDaoSqls.SELECT_PRODUCTS_BY_CATEGORYID, params, rowMapperDisplayInfo);
		}
		return jdbc.query(DisplayInfoDaoSqls.SELECT_PRODUCTS_ALL, params, rowMapperDisplayInfo);
	}

	public int selectProductCount(Integer categoryId, Integer start) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("categoryId", categoryId); 
		if (categoryId >= 1) {
			return jdbc.queryForObject(DisplayInfoDaoSqls.SELECT_TOTALCOUNT_BY_CATEGORYID, params, Integer.class);
		}
		return jdbc.queryForObject(DisplayInfoDaoSqls.SELECT_TOTALCOUNT_ALL, params, Integer.class);
	}

	public int selectTotalCount(Integer categoryId) {
		Map<String, Integer> params = Collections.singletonMap("categoryId", categoryId);
		if(categoryId>=1) {
			return jdbc.queryForObject(DisplayInfoDaoSqls.SELECT_TOTALCOUNT_BY_CATEGORYID, params, Integer.class);	
		}
		return jdbc.queryForObject(DisplayInfoDaoSqls.SELECT_TOTALCOUNT_ALL, params, Integer.class);
	}

	
	// api/displayinfos/{displayId}
	public List<DisplayInfo> selectProduct(Integer displayId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		return jdbc.query(DisplayInfoDaoSqls.SELECT_PRODUCT_BY_DISPLAYID, params, rowMapperDisplayInfo);
	}
	public List<DisplayImage> selectProductImages(Integer displayId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		return jdbc.query(DisplayInfoDaoSqls.SELECT_PRODUCT_IMAGES_BY_DISPLAYID, params, rowMapperDisplayImage);
	}
	public List<DisplayInfoImage> selectDisplayInfoImages(Integer displayId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		return jdbc.query(DisplayInfoDaoSqls.SELECT_DISPLAYINFO_IMAGES_BY_DISPLAYID, params, rowMapperDisplayInfoImage);
	}
	//
	public Integer selectAvgScore(Integer displayId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		//return jdbc.query(DisplayInfoDaoSqls.SELECT_AVG_SCORE_BY_DISPLAYID, params, rowMapper);
		return 3;
	}
	public List<DisplayPrice> selectProductPrices(Integer displayId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		return jdbc.query(DisplayInfoDaoSqls.SELECT_PRODUCT_PRICES_BY_DISPLAYID, params, rowMapperDisplayPrice);
	}
	
}
