//package kr.co.netmania.webbe.calculatorcli;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class CalculatorServiceTest {
//
//	CalculatorService calculatorService;
//	
//	@Before
//	public void init() {
//		this.calculatorService = new CalculatorService();
//	}
//	
//	@Test
//	public void plus() throws Exception{
//		int value1 = 10;
//		int value2 = 5;
//		
//		int result = calculatorService.plus(value1, value2);
//		
//		assertEquals(15, result);
//	}
//	
//	@Test
//	public void divide() throws Exception {
//		int value1 = 10;
//		int value2 = 5;
//		
//		int result = calculatorService.divide(value1, value2);
//		
//		assertEquals(2, result);
//	}
//	
//	@Test
//	public void divideExceptionTest() throws Exception{
//		int value1 = 10;
//		int value2 = 0;
//		
//		try {
//			calculatorService.divide(value1, value2);
//		} catch (ArithmeticException e) {
//			assertTrue(true);
//		}
//		fail();
//	}
//	
//}
