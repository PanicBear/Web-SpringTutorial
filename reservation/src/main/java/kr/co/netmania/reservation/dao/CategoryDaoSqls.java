package kr.co.netmania.reservation.dao;

public class CategoryDaoSqls {
	
	public static final String SELECT_CATEGORY_ITEMS = 
			"SELECT " + 
					"category.id, category.name, count(*) as count " + 
			"FROM " + 
				"connectdb.category " + 
			"INNER JOIN " + 
				"connectdb.product " + 
			"ON " + 
				"category.id = product.category_id " + 
			"GROUP BY " + 
				"product.category_id";

	public static final String SELECT_CATEGORY_SIZE = 
			"SELECT count(*) FROM connectdb.category";
}
