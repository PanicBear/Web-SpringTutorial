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
				"connectdb.promotion, " + 
				"connectdb.product, " + 
				"connectdb.category, " + 
				"connectdb.product_image " + 
			"WHERE " + 
				"promotion.product_id = product.id " + 
			"AND " + 
				"category.id = product.category_id " + 
			"AND " + 
				"product.id = product_image.product_id " +
			"GROUP BY " + 
				"promotion.id";
}
