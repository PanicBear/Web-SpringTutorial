package kr.co.netmania.reservation.contoller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.netmania.reservation.dto.DisplayInfoComment;
import kr.co.netmania.reservation.dto.DisplayInfoProduct;
import kr.co.netmania.reservation.service.ReservationService;

@RestController
@RequestMapping(path = "/api")
public class ReservationApiController {

	@Autowired
	private ReservationService reservationService;

	@ApiOperation(value = "카테고리 목록 구하기")
	@ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Exception")})
	@GetMapping("/categories")
	public Map<String, Object> categories(){
		Map<String, Object> map = new HashMap<>();
		map.put("size", reservationService.getCategorySize());
		map.put("items", reservationService.getCategoryItems());
		return map;
	}
	
	@ApiOperation(value = "상품 목록 구하기")
	@ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Exception")})
	@GetMapping("/displayinfos/{displayId}")
	public Map<String, Object> categories(@PathVariable(name = "displayId") int displayId){
		Map<String, Object> map = new HashMap<>();
		map.put("product", reservationService.getProduct(displayId));
		map.put("productImages", reservationService.getProductImages(displayId));
		map.put("displayInfoImages", reservationService.getDisplayInfoImages(displayId));
		map.put("avgScore", reservationService.getAvgScore(displayId));
		map.put("productPrices", reservationService.getProductPrices(displayId));
		return map;
	}

//	@ApiOperation(value = "상품 목록 구하기")
//	@ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Exception")})
//	@GetMapping("/displayinfos")
//	public Map<String, Object> displayInfosProductList(
//			@RequestParam(name = "categoryid", required = false, defaultValue = "0")int categoryId, 
//			@RequestParam(name = "start", required = false, defaultValue = "0")int start){
//		
//		List<DisplayInfoProduct> list = reservationService.getProducts(categoryId, start);
//		
//		Map<String, Object> map = new HashMap<>();
//		map.put("totalCount", reservationService.getProductTotalCount(categoryId, start));
//		map.put("productCount", list.size());
//		map.put("products", list);
//		return map;
//	}
	@ApiOperation(value = "상품 목록 구하기")
	@ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Exception")})
	@GetMapping("/displayinfos")
	public Map<String, Object> displayInfosProductList(
			@RequestParam(name = "categoryid", required = false, defaultValue = "0")int categoryId, 
			@RequestParam(name = "start", required = false, defaultValue = "0")int start,
			@RequestParam(name = "productid", required = false, defaultValue = "0")int productId){
		System.out.println("productId : "+productId+"categoryId : "+categoryId);
		if(productId != 0 && categoryId==0) {
			List<DisplayInfoComment> list = reservationService.getReservationUserComments(productId, start);
			
			Map<String, Object> map = new HashMap<>();
			map.put("totalCount", reservationService.getCommentTotalCount(productId, start));
			map.put("commentCount", list.size());
			map.put("products", list);
			return map;
		}
		
		List<DisplayInfoProduct> list = reservationService.getProducts(categoryId, start);
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", reservationService.getProductTotalCount(categoryId, start));
		map.put("productCount", list.size());
		map.put("products", list);
		return map;
	}
	
//	@ApiOperation(value = "댓글 목록 구하기")
//	@ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Exception")})
//	@GetMapping("/displayinfos")
//	public Map<String, Object> displayInfosCommentList(
//			@RequestParam(name = "productid", required = false, defaultValue = "0")int productId, 
//			@RequestParam(name = "start", required = false, defaultValue = "0")int start){
//		
//		List<DisplayInfoComment> list = reservationService.getReservationUserComments(productId, start);
//		
//		Map<String, Object> map = new HashMap<>();
//		map.put("totalCount", reservationService.getCommentTotalCount(productId, start));
//		map.put("commentCount", list.size());
//		map.put("products", list);
//		return map;
//	}
	
	@ApiOperation(value = "프로모션 목록 구하기")
	@ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Exception")})
	@GetMapping("/promotions")
	public Map<String, Object> promotions(){
		Map<String, Object> map = new HashMap<>();
		map.put("size", reservationService.getPromotionSize());
		map.put("items", reservationService.getPromotionItems());
		return map;
	}
}
