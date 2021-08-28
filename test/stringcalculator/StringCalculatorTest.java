package stringcalculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 18bce184 Rasik Prajapati
 */

public class StringCalculatorTest {
   
    private StringCalculator calculator = new StringCalculator();
    
    @org.junit.Test
    public void testEmptyString() {
        assertEquals(calculator.add(""), 0);
    }
}
