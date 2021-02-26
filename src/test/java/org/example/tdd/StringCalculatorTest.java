package org.example.tdd;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    private Calculator calculator=new StringCalculator();

    @Test
    public void shouldCalculateSumOfTwoNumbers(){
        String stringToCalculate="1,1";
        int actual=calculator.add(stringToCalculate);

        assertEquals(2,actual);
    }

    @Test
    public void shouldCalculateSumOfNumbers(){
        String stringToCalculate="1,1,2,9";
        int actual=calculator.add(stringToCalculate);

        assertEquals(13,actual);
    }

    @Test
    public void shouldCalculateSumOfNumbersWithNewLineSeparator(){
        String separator=System.lineSeparator();
        String stringToCalculate="10"+separator+"23"+separator+"7" ;
        int actual=calculator.add(stringToCalculate);

        assertEquals(40,actual);
    }

    @Test
    public void shouldCalculateSumOfNumbersWithDifferentSeparators(){
        String separator=System.lineSeparator();
        String stringToCalculate="10"+separator+"23:7,14 6,9";
        int actual=calculator.add(stringToCalculate);

        assertEquals(69,actual);
    }

    @Ignore
    @Test
    public void shouldShowExceptionWhenStringHasNegativeNumber(){
        String expectedMessage="Negative number are not allowed here. Value of: %d";
        String stringToCalculate="10,23:7,14 6,-9";
        String actualMessage="";

        try {
            int actual=calculator.add(stringToCalculate);
        }catch (RuntimeException e){
            actualMessage=e.getMessage();
        }
        assertEquals(String.format(expectedMessage, -9),actualMessage);
    }

    @Test
    public void shouldShowExceptionWhenStringHasNegativeNumbers(){
        String expectedMessage="Negative numbers are not allowed here. Value of: %s";
        String stringToCalculate="10,23:7,-14 6,-9";
        String actualMessage="";

        try {
            int actual=calculator.add(stringToCalculate);
        }catch (RuntimeException e){
            actualMessage=e.getMessage();
        }
        assertEquals(String.format(expectedMessage, "[-14, -9]"),actualMessage);
    }
}

