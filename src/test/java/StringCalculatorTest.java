import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    private StringCalculator calculator;


    @Before
    public void setUp() {

        calculator = new StringCalculator();
    }


    @Test
    public void givenEmptyString_shouldReturnZero() {

        assertEquals(calculator.add(""), 0);
    }

    @Test
    public void givenNumberOneInString_shouldReturnOne() {

        assertEquals(calculator.add("1"), 1);
    }

    @Test
    public void givenTwoNumbersSeparatedByComma_shouldReturnSum() {
        assertEquals(calculator.add("1,2"), 3);
    }

    @Test
    public void givenMultipleNumbersInStringSeparatedByComma_shouldReturnSum() {
        assertEquals(calculator.add("1,2,3,4"), 10);
    }

    @Test
    public void shouldAcceptNewLine() {
        assertEquals(calculator.add("1\n2,3,4"), 10);
    }

    @Test
    public void shouldAcceptCustomDelim() {
        assertEquals(calculator.add("//;\n1;2;3;4"), 10);
    }
}
