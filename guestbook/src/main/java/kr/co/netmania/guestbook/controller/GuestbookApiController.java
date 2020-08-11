package kr.co.netmania.guestbook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.netmania.guestbook.dto.Guestbook;
import kr.co.netmania.guestbook.service.GuestbookService;

@RestController
@RequestMapping(path = "/guestbooks")
public class GuestbookApiController {
	@Autowired
	GuestbookService guestbookService;

	@GetMapping // guestbooks url로 들어와 get방식으로 들어오면 이 메서드를 실행
	public Map<String, Object> list(@RequestParam(name = "start", required = false, defaultValue = "0") int start) {

		List<Guestbook> list = guestbookService.getGuestbooks(start);

		int count = guestbookService.getCount();
		int pageCount = count / GuestbookService.LIMIT;
		if (count % GuestbookService.LIMIT > 0) {
			pageCount++;
		}

		List<Integer> pageStartList = new ArrayList();
		for (int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
		}

		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pageStartList", pageStartList);

		return map;
	}

	@PostMapping // post 방식의 mapping일 경우 이 메서드가 호출됨
	public Guestbook write(@RequestBody Guestbook guestbook, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();

		Guestbook resultGuestbook = guestbookService.addGuestbook(guestbook, clientIp);
		return resultGuestbook;
	}

	// 클라이언트에게 응답할 때는 모두 json으로 변환되어 전송됨

	@DeleteMapping("/{id}")		// /guestbooks/{id}이 id의 정보를 pathvariable이라 함
	public Map<String, String> delete(@PathVariable(name = "id") Long id, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();

		int deleteCount = guestbookService.deleteGuestbook(id, clientIp);
		return Collections.singletonMap("success", deleteCount > 0 ? "true" : "false");	// map 객체 생성
		
	}
	// http://localhost:8080/guestbook/guestbooks
}
