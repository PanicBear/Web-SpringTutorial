package kr.co.netmania.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.netmania.mvcexam.dto.PlusResult;

@Controller
public class PlusApiController {
	@GetMapping("/api/plus")
	@ResponseBody
	public PlusResult plus(@RequestParam("value1") int value1, @RequestParam("value2")int value2) {
		PlusResult plusResult = new PlusResult();
		plusResult.setValue1(value1);
		plusResult.setValue2(value2);
		plusResult.setResult(value1+value2);
		
		return plusResult;
	}
	
	//  @ResponseBody 어노테이션이 붙게 되면
	//	해당 메서드는 뷰의 이름을 리턴하는 것이 아니라
	//	리턴한 객체를 출력하라는 의미를 가진다.
	
	//	보통 WebAPI는 JSON, XML과 같은 데이터를 표현하기에 알맞은 형태로 결과를 출력
	//	pom.xml에 json-core, json-databind 종속성 추가해줘야함
}
