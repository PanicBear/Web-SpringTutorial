package kr.co.netmania.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.netmania.reservation.dao.CategoryDao;
import kr.co.netmania.reservation.dao.DisplayInfoDao;
import kr.co.netmania.reservation.dao.PromotionDao;
import kr.co.netmania.reservation.dto.Category;
import kr.co.netmania.reservation.dto.DisplayInfo;
import kr.co.netmania.reservation.dto.Promotion;

@Service
public class ReservationService {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	DisplayInfoDao displayInfoDao;
	
	@Autowired
	PromotionDao promotionDao;
	
	// api/categories
	public int getCategorySize() {
		return categoryDao.selectCategorySize();
	}
	public List<Category> getCategoryItems() {
		return categoryDao.selectCategoryItems();
	}
	
	// api/displayinfos
	public int getTotalCount(Integer categoryId, Integer start) {
		return displayInfoDao.selectTotalCount(categoryId);
	}
	public int getProductCount(Integer categoryId, Integer start) {
		return displayInfoDao.selectProductCount(categoryId, start);
	}
	public List<DisplayInfo> getProducts(Integer categoryId, Integer start){
		return displayInfoDao.selectProducts(categoryId, start);
	}
	
	// api/promotions
	public int getPromotionSize() {
		return promotionDao.selectPromotionSize();
	}
	public List<Promotion> getPromotionItems() {
		return promotionDao.selectPromotionItems();
	}
}
