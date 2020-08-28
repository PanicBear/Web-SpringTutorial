package kr.co.netmania.reservation.contoller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.netmania.reservation.dto.DisplayInfo;
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
	@GetMapping("/displayinfos")
	public Map<String, Object> displayInfos(
			@RequestParam(name = "categoryid", required = false, defaultValue = "0")int categoryId, 
			@RequestParam(name = "start", required = false, defaultValue = "0")int start){
		
		List<DisplayInfo> list = reservationService.getProducts(categoryId, start);
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", reservationService.getTotalCount(categoryId, start));
		map.put("productCount", list.size());
		map.put("products", list);
		return map;
	}
}
