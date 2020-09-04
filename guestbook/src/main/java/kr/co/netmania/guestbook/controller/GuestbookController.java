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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.netmania.guestbook.dto.Guestbook;
import kr.co.netmania.guestbook.service.GuestbookService;

@Controller
public class GuestbookController {
	@Autowired
	GuestbookService guestbookService;

	@GetMapping(path = "/list")
	public String list(@RequestParam(name = "start", required = false, defaultValue = "0") int start, ModelMap model,
			@CookieValue(value = "count", defaultValue = "1", required = true) String value,
			HttpServletResponse response) {

		try {
			int i = Integer.parseInt(value);
			value = Integer.toString(++i); // 기존 쿠키가 나타내는 count 값 증가
		} catch (Exception ex) {
			ex.printStackTrace();
			value = "1";
		}
		
		Cookie cookie = new Cookie("count", value);
		cookie.setMaxAge(60 * 60 * 24 * 365); 	// 쿠키 유지, 초*분*시*일, 1년 / -1이면 브라우저 종료 시 삭제
											 	// 0으로 설정 시 바로 만료되기에 삭제 기능(삭제만 하는 기능은 아예 없음)
		cookie.setPath("/"); // 경로 이하에 모두 쿠키 적용
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
	
	@GetMapping(path="/delete")
	public String delete(@RequestParam(name="id", required = true)Long id,
			@SessionAttribute("isAdmin")String isAdmin,
			HttpServletRequest request,
			RedirectAttributes redirectAttr) {
		if(isAdmin == null || !"true".equals(isAdmin)) {	// 세션 값이 true가 아닐경우
			redirectAttr.addFlashAttribute("errorMessage", "로그인을 하지 않았습니다.");
			return "redirect:loginform";	// redirect로 플래시 맵 전송
		}
		String clientIp = request.getRemoteAddr();
		guestbookService.deleteGuestbook(id, clientIp);
		return "redirect:list";
	}
}
