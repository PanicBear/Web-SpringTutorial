package kr.co.netmania.guessnumber.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuessNumberController {

	@GetMapping(value = "/guess")
	public String guess(@RequestParam(name = "number", required = false) Integer number, HttpSession session,
			ModelMap model) {

		String message = null;

		if (number == null || session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
			session.setAttribute("randomNumber", (int) (Math.random() * 100 + 1));
			message = "임의 숫자 맞추기!";
		} else {
			int count = (Integer) session.getAttribute("count");
			int randomNumber = (Integer) session.getAttribute("randomNumber");

			if (number > randomNumber) {
				message = "입력한 숫자가 정답보다 큽니다.";
			} else if (number < randomNumber) {
				message = "입력한 숫자가 정답보다 작습니다.";
			} else {
				message = "정답입니다! 도전 횟수 : " + count + ", 정답 : " + randomNumber;
			}
			session.setAttribute("count", ++count);
			model.addAttribute("message", message);
		}

		return "guess";
	}
}
