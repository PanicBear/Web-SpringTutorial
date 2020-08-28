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

import kr.co.netmania.reservation.dto.DisplayInfo;

@Repository
public class DisplayInfoDao {
	public NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfo> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);

	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<DisplayInfo> selectProducts(Integer categoryId, Integer start) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("categoryId", categoryId);
		if (categoryId >= 1) {
			return jdbc.query(DisplayInfoDaoSqls.SELECT_PRODUCTS_BY_CATEGORYID, params, rowMapper);
		}
		return jdbc.query(DisplayInfoDaoSqls.SELECT_PRODUCTS_ALL, params, rowMapper);
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
}
