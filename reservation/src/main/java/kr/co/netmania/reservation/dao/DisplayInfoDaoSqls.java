package kr.co.netmania.reservation.dao;

public class DisplayInfoDaoSqls {
	
	public static final String SELECT_TOTALCOUNT_ALL =
			"SELECT "
				+ "count(*) as totalCount "
			+ "FROM	"
				+ "connectdb.product ";
	
	public static final String SELECT_TOTALCOUNT_BY_CATEGORYID =
			SELECT_TOTALCOUNT_ALL
			+ "WHERE "
				+ "product.category_id = :categoryId "; 
	
	public static final String SELECT_PRODUCTCOUNT_ALL =
			SELECT_TOTALCOUNT_ALL
			+ "LIMIT "
				+ ":start, 99999999";
	
	public static final String SELECT_PRODUCTCOUNT_BY_CATEGORYID = 
			SELECT_TOTALCOUNT_BY_CATEGORYID
			+ "LIMIT "
				+ ":start, 99999999";
	
	// 특정 카테고리 조회
	public static final String SELECT_PRODUCTS_BY_CATEGORYID = 
			"SELECT " + 
				"product.id, " + 
				"product.category_id, " + 
				"display_info.id AS displayInfoId, " + 
				"category.name, " + 
				"product.description, " + 
				"product.content, " + 
				"product.event, " + 
				"display_info.opening_hours, " + 
				"display_info.place_name, " + 
				"display_info.place_lot, " + 
				"display_info.place_street, " + 
				"display_info.tel, " + 
				"display_info.homepage, " + 
				"display_info.email, " + 
				"product.create_date, " + 
				"product.modify_date, " + 
				"product_image.file_id " + 
			"FROM  " + 
				"connectdb.product, " + 
				"connectdb.reservation_info, " + 
				"connectdb.category, " + 
				"connectdb.display_info, " + 
				"connectdb.product_image " + 
			"WHERE " + 
				"product_image.product_id = product.id " + 
				"AND " + 
				"category.id = product.category_id " + 
				"AND " + 
				"display_info.product_id = product.id " +
				"AND " + 
				"category.id = :categoryId " + 
			"GROUP BY " + 
				"product.id " +
			"LIMIT " +
				":start, 99999999 ";
	
	// 0이나 공백 시 카테고리  전체조회
	public static final String SELECT_PRODUCTS_ALL = 
			"SELECT " + 
				"product.id, " + 
				"product.category_id, " + 
				"display_info.id AS displayInfoId, " + 
				"category.name, " + 
				"product.description, " + 
				"product.content, " + 
				"product.event, " + 
				"display_info.opening_hours, " + 
				"display_info.place_name, " + 
				"display_info.place_lot, " + 
				"display_info.place_street, " + 
				"display_info.tel, " + 
				"display_info.homepage, " + 
				"display_info.email, " + 
				"product.create_date, " + 
				"product.modify_date, " + 
				"product_image.file_id " + 
			"FROM  " + 
				"connectdb.product, " + 
				"connectdb.reservation_info, " + 
				"connectdb.category, " + 
				"connectdb.display_info, " + 
				"connectdb.product_image " + 
			"WHERE " + 
				"product_image.product_id = product.id " + 
				"AND " + 
				"category.id = product.category_id " + 
				"AND " + 
				"display_info.product_id = product.id " +
			"GROUP BY " + 
				"product.id " +
			"LIMIT " +
				":start, 99999999 ";
	
}
