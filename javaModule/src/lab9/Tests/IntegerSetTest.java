package lab9.Tests;
import lab9.IntegerSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class IntegerSetTest {

    @Test
    public void testSumPositiveElements() {
        List<Integer> numbers = Arrays.asList(1, -2, 3, -4, 5);
        IntegerSet set = new IntegerSet(numbers);
        assertEquals(9, set.sumPositiveElements());
    }

    @Test
    public void testAverageAbove7() {
        List<Integer> numbers = Arrays.asList(1, 8, 10, -5, -3);
        IntegerSet set = new IntegerSet(numbers);
        assertEquals(9.0, set.averageAbove7(), 0.01);
    }

    @Test
    public void testMaxPositiveElement() {
        List<Integer> numbers = Arrays.asList(1, -2, 3, -4, 5);
        IntegerSet set = new IntegerSet(numbers);
        assertEquals(5, set.maxPositiveElement());
    }

    @Test
    public void testMinNegativeElement() {
        List<Integer> numbers = Arrays.asList(1, -2, 3, -4, 5);
        IntegerSet set = new IntegerSet(numbers);
        assertEquals(-4, set.minNegativeElement());
    }
}
