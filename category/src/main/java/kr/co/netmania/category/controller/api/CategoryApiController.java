package kr.co.netmania.category.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.netmania.category.dto.CategoryResult;
import kr.co.netmania.category.dto.CategoryWrapper;
import kr.co.netmania.category.service.CategoryListService;
import kr.co.netmania.category.service.CategoryService;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoryApiController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryListService categoryListService;

	@ApiOperation(value = "카테고리 목록 구하기")
	@ApiResponses({ @ApiResponse(code = 200, message = "Okay"), @ApiResponse(code = 500, message = "Exception") })
	@GetMapping
	public Map<String, Object> categories() {
		Map<String, Object> map = new HashMap<>();
		map.put("size", categoryListService.getCategorySize());
		map.put("items", categoryListService.getCategories());
		return map;
	}
}
