package lab8;

import java.util.*;
import java.util.concurrent.*;

public class TaskBus {
    private static final int BUS_CAPACITY = 10;
    private static final int NUM_BUSES = 5;
    private static final int NUM_PASSENGERS = 50;
    private static final Random random = new Random();
    private static final BlockingQueue<Integer> busQueue = new LinkedBlockingQueue<>();

    public static void runBusSystem() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_BUSES + 1);

        for (int i = 0; i < NUM_BUSES; i++) {
            final int busNumber = i + 1;
            executor.submit(() -> {
                try {
                    runBus(busNumber);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.submit(() -> {
            try {
                generatePassengers();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.sleep(30000);
        executor.shutdown();
    }

    private static void generatePassengers() throws InterruptedException {
        for (int i = 0; i < NUM_PASSENGERS; i++) {
            int busNumber = random.nextInt(NUM_BUSES) + 1;
            busQueue.put(busNumber);
            System.out.println("Passenger waiting for bus " + busNumber);
            Thread.sleep(random.nextInt(1000));
        }
    }

    private static void runBus(int busNumber) throws InterruptedException {
        while (!Thread.interrupted()) {
            System.out.println("Bus " + busNumber + " arrived.");
            int passengersOnBoard = 0;

            while (!busQueue.isEmpty() && passengersOnBoard < BUS_CAPACITY) {
                Integer passengerBus = busQueue.take();
                if (passengerBus == busNumber) {
                    passengersOnBoard++;
                    System.out.println("Passenger boarded bus " + busNumber);
                } else {
                    busQueue.put(passengerBus);
                }
            }

            System.out.println("Bus " + busNumber + " departs with " + passengersOnBoard + " passengers.");
            Thread.sleep(5000);
        }
    }
}
