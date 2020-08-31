package kr.co.netmania.reservation.dao;

public class DisplayInfoDaoSqls {
	
	public static final String SELECT_PRODUCT_TOTALCOUNT_ALL =
			"SELECT "
				+ "count(product.id) as totalCount "
			+ "FROM	"
				+ "connectdb.product ";
	
	public static final String SELECT_PRODUCT_TOTALCOUNT_BY_CATEGORYID =
			SELECT_PRODUCT_TOTALCOUNT_ALL
			+ "WHERE "
				+ "product.category_id = :categoryId "; 
	
	public static final String SELECT_PRODUCTCOUNT_ALL =
			SELECT_PRODUCT_TOTALCOUNT_ALL
			+ "LIMIT "
				+ ":start, 99999999";
	
	public static final String SELECT_PRODUCTCOUNT_BY_CATEGORYID = 
			SELECT_PRODUCT_TOTALCOUNT_BY_CATEGORYID
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
	
	// displayId를 통한 상세정보 조회
	public static final String SELECT_PRODUCT_BY_DISPLAYID = 
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
				"display_info.product_id = :displayId " +
			"GROUP BY " + 
				"product.id";
	
	public static final String SELECT_PRODUCT_IMAGES_BY_DISPLAYID =
			"SELECT " + 
				"product.id, " + 
				"product_image.id, " + 
				"product_image.type, " + 
				"product_image.file_id, " + 
				"file_info.file_name, " + 
				"file_info.save_file_name, " + 
				"file_info.content_type, " + 
				"file_info.delete_flag, " +	 
				"file_info.create_date, " + 
				"file_info.modify_date " + 
			"FROM " + 
				"connectdb.product, " + 
				"connectdb.file_info, " + 
				"connectdb.display_info, " + 
				"connectdb.product_image " + 
			"WHERE " + 
				"product_image.product_id = product.id " + 
				"AND " + 
				"file_info.id = product_image.file_id " + 
				"AND " + 
				"display_info.product_id = product.id " + 
				"AND " + 
				"display_info.id = :displayId " + 
			"GROUP BY " + 
				"product.id";
	
	public static final String SELECT_DISPLAYINFO_IMAGES_BY_DISPLAYID =
			"SELECT " + 
				"display_info_image.id, " + 
				"display_info.id, " + 
				"file_info.id, " + 
				"file_info.file_name, " + 
				"file_info.save_File_Name, " + 
				"file_info.content_Type, " + 
				"file_info.delete_Flag, " + 
				"file_info.create_Date, " + 
				"file_info.modify_Date " + 
			"FROM " + 
				"connectdb.display_info, " + 
				"connectdb.display_info_image, " + 
				"connectdb.file_info " + 
			"WHERE " + 
				"display_info_image.display_info_id = display_info.id " + 
				"AND " + 
				"display_info_image.file_id = file_info.id " + 
				"AND " + 
				"display_info.id = :displayId ";
	
	public static final String SELECT_AVG_SCORE_BY_DISPLAYID = 
			"SELECT " + 
				"round(avg(reservation_user_comment.score)) as avgScore " + 
			"FROM " + 
				"connectdb.reservation_info, " + 
				"connectdb.reservation_user_comment, " + 
				"connectdb.display_info     " + 
			"WHERE " + 
				"display_info.id = reservation_info.display_info_id " + 
			"AND " + 
				"reservation_info.id = reservation_user_comment.reservation_info_id " + 
			"AND " + 
				"display_info.id = :displayId ";
	
	public static final String SELECT_PRODUCT_PRICES_BY_DISPLAYID =
			"SELECT " + 
				"* " + 
			"FROM " + 
				"connectdb.product_price, " + 
				"connectdb.product, " + 
				"connectdb.display_info " + 
			"WHERE " + 
				"display_info.product_id = product.id " + 
				"AND " + 
				"product.id = product_price.product_id " + 
				"AND " + 
				"display_info.id = :displayId";

	public static final String SELECT_COMMENT_TOTALCOUNT_BY_PRODUCTID =
			"SELECT " + 
			"count(reservation_user_comment.id) AS count " + 
			"FROM " + 
			"connectdb.reservation_user_comment " + 
			"WHERE " + 
			"reservation_user_comment.product_id = :productId";

	public static final String SELECT_COMMENT_TOTALCOUNT_ALL =
			"SELECT "+
				"count(reservation_user_comment.id) AS count " +
			"FROM "+
				"connectdb.reservation_user_comment";
	
	public static final String SELECT_COMMENTCOUNT_BY_PRODUCTID =
			SELECT_COMMENT_TOTALCOUNT_BY_PRODUCTID
			+ "LIMIT "
				+ ":start, :limit";
	
	public static final String SELECT_COMMENTCOUNT_ALL =
			SELECT_COMMENT_TOTALCOUNT_ALL
			+ "LIMIT "
				+ ":start, :limit";

	public static final String SELECT_RESERVATIONUSERCOMMENTS_BY_PRODUCTID = 
			"SELECT " + 
				"* " + 
			"FROM " + 
				"connectdb.reservation_user_comment " + 
			"WHERE " + 
				"reservation_user_comment.product_id " + 
				"AND " + 
				"reservation_user_comment.product_id = :productId " + 
			"LIMIT " + 
				":start, :limit";

	public static final String SELECT_RESERVATIONUSERCOMMENTS_ALL = 
			"SELECT " + 
				"* " + 
			"FROM " + 
				"connectdb.reservation_user_comment " + 
			"WHERE " + 
				"reservation_user_comment.product_id " + 
			"LIMIT " + 
				":start, :limit";
}
