package stringcalculator;

import static org.junit.Assert.*;

/**
 *
 * @author 18bce184 Rasik Prajapati
 */

public class StringCalculatorTest {
   
    private StringCalculator calculator = new StringCalculator();
    
    @org.junit.Test
    public void testZeroCalledCount() {
        assertEquals(calculator.getCalledCount(), 0);
    }
    
    @org.junit.Test
    public void testEmptyString() throws Exception {
        assertEquals(calculator.add(""), 0);
    }
    
    @org.junit.Test
    public void testSingleCalledCount() throws Exception {
        calculator.add("");
        assertEquals(calculator.getCalledCount(), 1);
    }
    
    @org.junit.Test
    public void testForNumberGreaterThanThousand() throws Exception {
        assertEquals(calculator.add("1,1001,2"), 3);
    }
    
    @org.junit.Test
    public void testForAnyLengthDelimiter() throws Exception {
        assertEquals(calculator.add("//[***]\n1***2***3"), 6);
    }
    
    @org.junit.Test
    public void testMultipleCalledCount() throws Exception {
        calculator.add("");
        calculator.add("");
        calculator.add("");
        assertEquals(calculator.getCalledCount(), 3);
    }
    
    @org.junit.Test
    public void testSingleValue() throws Exception {
        assertEquals(calculator.add("1"), 1);
    }
    
    @org.junit.Test
    public void testTwoValues() throws Exception {
        assertEquals(calculator.add("1,2"), 3);
    }
    
    @org.junit.Test
    public void testUnknownAmountOfValues() throws Exception {
        assertEquals(calculator.add("1,2,3,4,5"), 15);
    }
    
    @org.junit.Test
    public void testNewLineDelimitedValues() throws Exception {
        assertEquals(calculator.add("1,2\n3"), 6);
    }
    
    @org.junit.Test
    public void testCustomDelimitedValues() throws Exception {
        assertEquals(calculator.add("//;\n1;2;3"), 6);
    }
    
    @org.junit.Test(expected = Exception.class)
    public void testNegativeValues() throws Exception{
        try{
            calculator.add("-3");
        }catch(Exception e){
            assertEquals(e.getMessage(),"Negatives not allowed : -3");
            throw e;
        }
    }
    
    @org.junit.Test(expected = Exception.class)
    public void testMultipleNegativeValues() throws Exception{
        try{
            calculator.add("-3,-4,6,-7");
        }catch(Exception e){
            assertEquals(e.getMessage(),"Negatives not allowed : -3 -4 -7");
            throw e;
        }
    }
    
    @org.junit.Test
    public void testMultipleDelimiters() throws Exception{
        assertEquals(calculator.add("//[*][%]\n1*2%3"), 6);
    }
    
    @org.junit.Test
    public void testAnyLengthMultipleDelimiters() throws Exception{
        assertEquals(calculator.add("//[**][%%]\n1**2%%3"), 6);
    }
}
