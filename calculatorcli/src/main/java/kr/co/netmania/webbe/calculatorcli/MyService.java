package kr.co.netmania.webbe.calculatorcli;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	public final CalculatorService calculatorService;
	
	public MyService(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
	public int execute(int value1, int value2) {
		return calculatorService.plus(value1, value2)*2;
	}
}
