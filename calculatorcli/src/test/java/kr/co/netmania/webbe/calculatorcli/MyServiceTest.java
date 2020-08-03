package kr.co.netmania.webbe.calculatorcli;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MyServiceTest {
	@InjectMocks
	MyService myService;
	
	@Mock
	CalculatorService calculatorService;

	@Test
	public void execute() throws Exception {
		int value1 = 5;
		int value2 = 10;
		when(calculatorService.plus(5, 10)).thenReturn(15);

		int result = myService.execute(value1, value2);

		verify(calculatorService).plus(anyInt(), anyInt());
		assertEquals(30, result);
	}
}
