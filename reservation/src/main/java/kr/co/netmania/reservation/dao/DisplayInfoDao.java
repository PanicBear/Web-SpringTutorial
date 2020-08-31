package kr.co.netmania.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.netmania.reservation.dto.DisplayImage;
import kr.co.netmania.reservation.dto.DisplayInfoComment;
import kr.co.netmania.reservation.dto.DisplayInfoProduct;
import kr.co.netmania.reservation.dto.DisplayInfoImage;
import kr.co.netmania.reservation.dto.DisplayPrice;

@Repository
public class DisplayInfoDao {
	public NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfoProduct> rowMapperDisplayInfo = BeanPropertyRowMapper
			.newInstance(DisplayInfoProduct.class);
	private RowMapper<DisplayImage> rowMapperDisplayImage = BeanPropertyRowMapper.newInstance(DisplayImage.class);
	private RowMapper<DisplayInfoImage> rowMapperDisplayInfoImage = BeanPropertyRowMapper
			.newInstance(DisplayInfoImage.class);
	private RowMapper<DisplayPrice> rowMapperDisplayPrice = BeanPropertyRowMapper.newInstance(DisplayPrice.class);
	private RowMapper<DisplayInfoComment> rowMapperDisplayInfoComment = BeanPropertyRowMapper
			.newInstance(DisplayInfoComment.class);

	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	// api/displayinfos
	// parameter : categoryId, start
	// 상품 목록 구하기
	public List<DisplayInfoProduct> selectProducts(Integer categoryId, Integer start) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("categoryId", categoryId);
		if (categoryId != 0) {
			return jdbc.query(DisplayInfoDaoSqls.SELECT_PRODUCTS_BY_CATEGORYID, params, rowMapperDisplayInfo);
		}
		return jdbc.query(DisplayInfoDaoSqls.SELECT_PRODUCTS_ALL, params, rowMapperDisplayInfo);
	}

	public int selectProductCount(Integer categoryId, Integer start) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("categoryId", categoryId);
		if (categoryId != 0) {
			return jdbc.queryForObject(DisplayInfoDaoSqls.SELECT_PRODUCTCOUNT_BY_CATEGORYID, params, Integer.class);
		}
		return jdbc.queryForObject(DisplayInfoDaoSqls.SELECT_PRODUCTCOUNT_ALL, params, Integer.class);
	}

	public int selectProductTotalCount(Integer categoryId) {
		Map<String, Integer> params = Collections.singletonMap("categoryId", categoryId);
		if (categoryId != 0) {
			return jdbc.queryForObject(DisplayInfoDaoSqls.SELECT_PRODUCT_TOTALCOUNT_BY_CATEGORYID, params,
					Integer.class);
		}
		return jdbc.queryForObject(DisplayInfoDaoSqls.SELECT_PRODUCT_TOTALCOUNT_ALL, params, Integer.class);
	}

	// api/displayinfos
	// parameter : productId, start
	// 댓글 목록 구하기
	public int selectCommentTotalCount(Integer productId) {
		Map<String, Integer> params = Collections.singletonMap("productId", productId);
		if (productId != 0) {
			return jdbc.queryForObject(DisplayInfoDaoSqls.SELECT_COMMENT_TOTALCOUNT_BY_PRODUCTID, params,
					Integer.class);
		}
		return jdbc.queryForObject(DisplayInfoDaoSqls.SELECT_COMMENT_TOTALCOUNT_ALL, params, Integer.class);
	}

	public int selectCommentCount(Integer productId, Integer start, Integer limit) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		params.put("start", start);
		params.put("limit", limit);

		if (productId != 0) {
			return jdbc.queryForObject(DisplayInfoDaoSqls.SELECT_COMMENTCOUNT_BY_PRODUCTID, params, Integer.class);
		}
		return jdbc.queryForObject(DisplayInfoDaoSqls.SELECT_COMMENTCOUNT_ALL, params, Integer.class);
	}

	public List<DisplayInfoComment> selectReservationUserComments(Integer productId, Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("limit", limit);
		params.put("start", start);
		params.put("productId", productId);
		if (productId != 0) {
			return jdbc.query(DisplayInfoDaoSqls.SELECT_RESERVATIONUSERCOMMENTS_BY_PRODUCTID, params,
					rowMapperDisplayInfoComment);
		}
		return jdbc.query(DisplayInfoDaoSqls.SELECT_RESERVATIONUSERCOMMENTS_ALL, params, rowMapperDisplayInfoComment);
	}

	// api/displayinfos/{displayId}
	public List<DisplayInfoProduct> selectProduct(Integer displayId) {
		Map<String, Integer> params = Collections.singletonMap("displayId", displayId);
		return jdbc.query(DisplayInfoDaoSqls.SELECT_PRODUCT_BY_DISPLAYID, params, rowMapperDisplayInfo);
	}

	public List<DisplayImage> selectProductImages(Integer displayId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		return jdbc.query(DisplayInfoDaoSqls.SELECT_PRODUCT_IMAGES_BY_DISPLAYID, params, rowMapperDisplayImage);
	}

	public List<DisplayInfoImage> selectDisplayInfoImages(Integer displayId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		return jdbc.query(DisplayInfoDaoSqls.SELECT_DISPLAYINFO_IMAGES_BY_DISPLAYID, params, rowMapperDisplayInfoImage);
	}

	//
	public Integer selectAvgScore(Integer displayId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		return jdbc.queryForObject(DisplayInfoDaoSqls.SELECT_AVG_SCORE_BY_DISPLAYID, params, Integer.class);
	}

	public List<DisplayPrice> selectProductPrices(Integer displayId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		return jdbc.query(DisplayInfoDaoSqls.SELECT_PRODUCT_PRICES_BY_DISPLAYID, params, rowMapperDisplayPrice);
	}
}
