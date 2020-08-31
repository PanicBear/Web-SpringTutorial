package kr.co.netmania.reservation.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.netmania.reservation.dto.Promotion;

@Repository
public class PromotionDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Promotion> rowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);

	public PromotionDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public int selectPromotionSize() {
		return jdbc.queryForObject(PromotionDaoSqls.SELECT_PROMOTION_SIZE, Collections.emptyMap(), Integer.class);
	}

	public List<Promotion> selectPromotionItems() {
		return jdbc.query(PromotionDaoSqls.SELECT_PROMOTION_ITEMS, rowMapper);
	}

}
