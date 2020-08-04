package kr.co.netmania.daoexam.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.co.netmania.daoexam.dto.Role;

@Repository
public class RoleDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("role");
	}
	
	public List<Role> selectAll(){
		return jdbc.query(RoleDaoSql.SELECT_ALL, rowMapper);
	}

	// insert문의 경우, 자동으로 primary key를 자동 생성해야 하는 경우도 존재
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);	// role 객체를 map으로 바꿔주되, column으로 생성해줌
		return insertAction.execute(params);
	}
	
	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);	// role 객체를 map으로 바꿔주되, column으로 생성해줌
		return jdbc.update(RoleDaoSql.UPDATE, params);
	}
	
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("roleId", id);		// 값이 하나 일 경우 map 생성
		return jdbc.update(RoleDaoSql.DELETE_BY_ROLE_ID, params);
	}
	
	public Role selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id);		// 값이 하나 일 경우 map 생성
			return jdbc.queryForObject(RoleDaoSql.SELECT_BY_ROLE_ID, params, rowMapper);
		} catch (Exception e) {
			return null;
		}
	}
}

/*
 * @Repository public class RoleDao { // 기존 JDBC의 경우, ?를 통해 바인딩했기 때문에 가독성이 저하됨
 * // NamedPrameterJdbcTemplate의 경우, 이름을 통해 바인딩 하기에 상기 문제 해결 private
 * NamedParameterJdbcTemplate jdbc; private RowMapper<Role> rowMapper =
 * BeanPropertyRowMapper.newInstance(Role.class);
 * 
 * // 스프링 4.3부터는 componentScan으로 객체를 찾았을 때, 기본 생성자가 없다면 자동으로 객체 주입 //
 * 여기에서는 @Bean으로 등록했던 dataSource()가 파라미터로 전달됨 public RoleDao(DataSource
 * dataSource) { this.jdbc = new NamedParameterJdbcTemplate(dataSource); }
 * 
 * public List<Role> selectAll() { return jdbc.query(RoleDaoSql.SELECT_ALL,
 * Collections.EMPTY_MAP, rowMapper); } }
 */
