package UI;

import Domain.Aggregate.Dispatcher;
import Domain.Models.Autobase.Car;
import Domain.Models.Autobase.CargoRequest;
import Domain.Models.Autobase.Driver;

import java.util.Scanner;

public class TripListing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dispatcher dispatcher = new Dispatcher();

        dispatcher.addDriver(new Driver("John", 5));
        dispatcher.addDriver(new Driver("Mike", 3));
        dispatcher.addCar(new Car("Truck A", 1000));
        dispatcher.addCar(new Car("Truck B", 1500));

        while (true) {
            System.out.println("Enter cargo destination: ");
            String destination = scanner.nextLine();
            System.out.println("Enter cargo weight: ");
            double weight = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter cargo type: ");
            String cargoType = scanner.nextLine();

            CargoRequest request = new CargoRequest(destination, weight, cargoType);
            dispatcher.createTrip(request);

            dispatcher.printDriverStatistics();
            dispatcher.printDestinationStatistics();
            dispatcher.printTopEarners();

            System.out.println("Do you want to create another trip? (yes/no)");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }
}