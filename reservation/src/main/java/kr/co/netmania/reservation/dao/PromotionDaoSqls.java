package kr.co.netmania.reservation.dao;

public class PromotionDaoSqls {
	
	public static final String SELECT_PROMOTION_SIZE =
			"SELECT " + 
				"count(*) " + 
			"FROM " + 
				"connectdb.promotion";
	
	public static final String SELECT_PROMOTION_ITEMS =
			"SELECT " + 
			"connectdb.promotion.id, " + 
			"connectdb.promotion.product_id, " + 
			"connectdb.product.category_id, " + 
			"connectdb.category.name, " + 
			"connectdb.product.description, " + 
			"connectdb.product_image.file_id " + 
			"FROM " + 
			"connectdb.promotion " + 
			"INNER JOIN " + 
			"connectdb.product " + 
			"ON " + 
			"product.id=promotion.product_id " + 
			"INNER JOIN " + 
			"connectdb.category " + 
			"ON " + 
			"category.id=product.category_id " + 
			"INNER JOIN " + 
			"connectdb.product_image " + 
			"ON " + 
			"product_image.product_id=product.id " + 
			"GROUP BY " + 
			"promotion.id";
}
