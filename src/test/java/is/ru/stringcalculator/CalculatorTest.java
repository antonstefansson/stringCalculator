package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testMultipleElements(){
    	assertEquals(21, Calculator.add("1,2,3,4,5,6"));
    }

    @Test
    public void testNewLine(){
    	assertEquals(6, Calculator.add("1,2\n3"));
    }

    @Test
    public void testNewDelimiter(){
    	assertEquals(4, Calculator.add("//;\n2;2"));
    }
}