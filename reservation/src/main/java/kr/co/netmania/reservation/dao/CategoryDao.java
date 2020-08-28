package kr.co.netmania.reservation.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.netmania.reservation.dto.Category;

@Repository
public class CategoryDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);

	public CategoryDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Category> selectCategoryItems() {
		return jdbc.query(CategoryDaoSqls.SELECT_CATEGORY_ITEMS, rowMapper);
	}
	
	public int selectCategorySize() {
		return jdbc.queryForObject(CategoryDaoSqls.SELECT_CATEGORY_SIZE, Collections.emptyMap(), Integer.class);
	}
}
