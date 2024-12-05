package lab8;

import java.util.Random;

public class TaskArray {
    private static final int ARRAY_SIZE = 100;
    public static final int[] numbers = new int[ARRAY_SIZE];

    public static void fillArray() {
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }
    }

    public static Integer calculateSum() {
        return java.util.Arrays.stream(numbers).sum();
    }

    public static Double calculateAverage() {
        return java.util.Arrays.stream(numbers).average().orElse(0.0);
    }
}

