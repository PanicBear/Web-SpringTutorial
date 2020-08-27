package kr.co.netmania.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.netmania.category.dao.CategoryDao;
import kr.co.netmania.category.dto.Category;

@Service
public class CategoryListService  {
	
	@Autowired
	CategoryDao categoryDao;
	
	@Transactional(readOnly = true)
	public List<Category> getCategories(){
		List<Category> list = categoryDao.selectAll();
		return list;
	}
	
	@Transactional(readOnly = true)
	public int getCategorySize() {
		return categoryDao.selectCategorySize();
	}
	
}
