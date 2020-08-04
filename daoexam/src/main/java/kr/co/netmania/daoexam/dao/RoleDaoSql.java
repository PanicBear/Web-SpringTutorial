package kr.co.netmania.daoexam.dao;

public class RoleDaoSql {
	public static final String SELECT_ALL = "SELECT role_id, description FROM role ORDER BY role_id";
	// :~ 이 부분이 값으로 바인딩 될 부분
	public static final String UPDATE = "UPDATE role SET description = :description WHERE role_id = :roleId";
	public static final String SELECT_BY_ROLE_ID = "SELECT role_id, description FROM role where role_id = :roleId";
	public static final String DELETE_BY_ROLE_ID = "DELETE FROM role WHERE role_id = :roleId";
	
}
