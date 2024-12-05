package lab9.Tests;

import lab9.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Assertions.assertEquals(7.0, Calculator.add(3.0, 4.0));
    }

    @Test
    public void testSubtract() {
        assertEquals(1.0, Calculator.subtract(5.0, 4.0));
    }

    @Test
    public void testMultiply() {
        assertEquals(12.0, Calculator.multiply(3.0, 4.0));
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, Calculator.divide(8.0, 4.0));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(8.0, 0));
    }

    @Test
    public void testMax() {
        assertEquals(5.0, Calculator.max(3.0, 5.0));
    }

    @Test
    public void testMin() {
        assertEquals(3.0, Calculator.min(3.0, 5.0));
    }

    @Test
    public void testPercent() {
        assertEquals(20.0, Calculator.percent(200, 10));
    }

    @Test
    public void testPower() {
        assertEquals(8.0, Calculator.power(2.0, 3.0));
    }
}
