package kr.co.netmania.category.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.co.netmania.category.dto.Category;

@Repository
public class CategoryDao {

		private NamedParameterJdbcTemplate jdbc;
		private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
		
		public CategoryDao(DataSource dataSource) {
			this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		}
		
		public List<Category> selectAll(){
			return jdbc.query(CategoryDaoSqls.SELECT_CATEGORY, rowMapper);
		}
		
		public int selectCategorySize() {
			return jdbc.queryForObject(CategoryDaoSqls.SELECT_CATEGORY_SIZE, Collections.emptyMap(), Integer.class);
		}
}
