package lab9;// IntegerSet.java
import java.util.*;

public class IntegerSet {

    private final List<Integer> numbers;

    public IntegerSet(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sumPositiveElements() {
        return numbers.stream().filter(n -> n > 0).mapToInt(Integer::intValue).sum();
    }

    public double averageAbove7() {
        return numbers.stream()
                .filter(n -> Math.abs(n) > 7)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);
    }

    public int maxPositiveElement() {
        return numbers.stream().filter(n -> n > 0).max(Integer::compare).orElse(Integer.MIN_VALUE);
    }

    public int minNegativeElement() {
        return numbers.stream().filter(n -> n < 0).min(Integer::compare).orElse(Integer.MAX_VALUE);
    }
}
