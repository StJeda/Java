package lab8.Tests;

import lab8.TaskArray;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static lab8.TaskArray.numbers;

public class TaskArrayTest {
    public static void main() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<?> fillArrayFuture = executor.submit(TaskArray::fillArray);
        Future<Integer> sumFuture = executor.submit(TaskArray::calculateSum);
        Future<Double> avgFuture = executor.submit(TaskArray::calculateAverage);

        fillArrayFuture.get();

        Integer sum = sumFuture.get();
        Double avg = avgFuture.get();

        System.out.println("Array: " + java.util.Arrays.toString(numbers));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);

        executor.shutdown();
    }
}
