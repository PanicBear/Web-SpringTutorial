package kr.co.netmania.webbe.calculatorcli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class CalculatorServiceTest {

	@Autowired
	CalculatorService calculatorService;
	
	@Test
	public void init() {
		this.calculatorService = new CalculatorService();
	}
	
	@Test
	public void plus() throws Exception{
		int value1 = 10;
		int value2 = 5;
		
		int result = calculatorService.plus(value1, value2);
		
		assertEquals(result, 15);
	}
	
	@Test
	public void divide() throws Exception {
		int value1 = 10;
		int value2 = 5;
		
		int result = calculatorService.divide(value1, value2);
		
		assertEquals(result, 2);
	}
	
	@Test
	public void divideExceptionTest() throws Exception{
		int value1 = 10;
		int value2 = 0;
		
		try {
			calculatorService.divide(value1, value2);
		} catch (ArithmeticException e) {
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}
	
}
