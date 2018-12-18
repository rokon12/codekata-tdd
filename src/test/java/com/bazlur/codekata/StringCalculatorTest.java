package com.bazlur.codekata;

import com.bazlur.codedata.StringCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @Before
    public void setUp() {
        calculator = new StringCalculator();
    }


    @Test
    public void givenEmptyString_shouldReturnZero() {
        var sum = calculator.add("");

        assertThat(sum, is(0));
    }

    @Test
    public void givenOneInString_shouldReturn1() {
        var sum = calculator.add("1");

        assertThat(sum, is(1));
    }

    @Test
    public void givenTwoNumberInStringDelimByComma_shouldReturnSum() {
        var sum = calculator.add("1,2");

        assertThat(sum, is(3));
    }

    @Test
    public void givenMultipleNumberInStringDelimByComma_shouldReturnSUm() {
        assertThat(calculator.add("1,2,3"), is(6));
    }

    @Test
    public void givenNewLineAsDelim_shouldAccept() {
        assertThat(calculator.add("1,2\n3"), is(6));
    }

    @Test
    public void givenCustomDelim_shouldAccept() {
        assertThat(calculator.add("//;\n1;2"), is(3));
    }

}
