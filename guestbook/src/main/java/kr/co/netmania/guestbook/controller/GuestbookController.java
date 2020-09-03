package kr.co.netmania.guestbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.netmania.guestbook.dto.Guestbook;
import kr.co.netmania.guestbook.service.GuestbookService;

@Controller
public class GuestbookController {
	@Autowired
	GuestbookService guestbookService;

	@GetMapping(path = "/list")
	public String list(
			@RequestParam(name = "start", required = false, defaultValue = "0") int start, 
			ModelMap model,
			@CookieValue(value = "count", defaultValue = "0", required=true) String value,
			/* HttpServletRequest request, 대체  */			
			HttpServletResponse response) {


		// @CookieValue를 통해 필요 없어지는 코드
		// 기존 쿠키 찾기, null 여부확인
		
//		// 기존 쿠키
//		String value = null;
//		boolean find = false;
//		Cookie[] cookies = request.getCookies();	// 쿠키가 여러개 일 수 있기 때문에, 항상 배열로 수신
//		if(cookies != null) {						// 쿠키가 없으면 null 반환하기에 분기 필요
//			for(Cookie cookie : cookies) {
//				if("count".equals(cookie.getName())) {
//					find = true;
//					value = cookie.getValue();
//					break;
//				}
//			}
//		}
//		
//		
//		// 하는 일
//		if(!find) {		// null이 들어온 경우 분기(첫 요청으로 빈 쿠키)
//			value = "1";	// 쿠키는 문자열로 구성되기에 String
//		}else {
			try {
				int i = Integer.parseInt(value);
				value = Integer.toString(++i);		// 기존 쿠키가 나타내는 count 값 증가
			}catch (Exception ex) {
				ex.printStackTrace();
				value = "1";
			}
//		}

		// 쿠키 생성
		Cookie cookie = new Cookie("count", value);
		cookie.setMaxAge(60 * 60 * 24 * 365);	// 쿠키 유지, 초*분*시*일, 1년 / -1이면 브라우저 종료 시 삭제
												// 0으로 설정 시 바로 만료되기에 삭제 기능(삭제만 하는 기능은 아예 없음)
		cookie.setPath("/");	// 경로 이하에 모두 쿠키 적용 
		response.addCookie(cookie);

		List<Guestbook> list = guestbookService.getGuestbooks(start);

		int count = guestbookService.getCount();
		int pageCount = count / guestbookService.LIMIT;
		if (count % GuestbookService.LIMIT > 0) {
			pageCount++;
		}

		List<Integer> pageStartList = new ArrayList<>();
		for (int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
		}

		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageStartList", pageStartList);
		model.addAttribute("cookieCount", value);

		return "list";
	}

	@PostMapping(path = "/write")
	public String write(@ModelAttribute Guestbook guestbook, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		System.out.println("clientIp : " + clientIp);
		guestbookService.addGuestbook(guestbook, clientIp);
		return "redirect:list";
	}
}
