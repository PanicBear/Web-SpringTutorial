package kr.co.netmania.category.dao;

public class CategoryDaoSqls {
	public static final String SELECT_CATEGORY = 
			"SELECT " 
					+ "category.id, category.name, count(*) " 
				+ "FROM " 
					+ "connectdb.category, " 
					+ "connectdb.product "
				+ "WHERE " 
					+ "category.id = product.category_id "
				+ "GROUP BY " 
					+ "product.category_id";
	
	public static final String SELECT_CATEGORY_SIZE =
			"SELECT count(*) FROM connectdb.category";
}
