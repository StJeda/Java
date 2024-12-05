package Domain.Aggregate;

import Domain.Models.Autobase.Car;
import Domain.Models.Autobase.CargoRequest;
import Domain.Models.Autobase.Driver;
import Domain.Models.Autobase.Trip;
import Core.Services.LoggingService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dispatcher {
    private final List<Driver> drivers = new ArrayList<>();
    private final List<Car> cars = new ArrayList<>();
    private final List<Trip> trips = new ArrayList<>();


    private final Map<Driver, Double> driverCargoWeight = new HashMap<>();
    private final Map<String, Double> destinationCargoWeight = new HashMap<>();
    private final Map<Driver, Double> driverEarnings = new HashMap<>();

    public void addDriver(Driver driver) {
        drivers.add(driver);
        driverCargoWeight.put(driver, 0.0);
        driverEarnings.put(driver, 0.0);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void createTrip(CargoRequest request) {
        Driver selectedDriver = selectDriver(request);
        Car selectedCar = selectCar(request);

        if (selectedDriver != null && selectedCar != null) {
            Trip trip = new Trip(selectedDriver, selectedCar, request);
            trips.add(trip);
            LoggingService.logTrip("Created trip for " + selectedDriver.getName() + " with car " + selectedCar.getModel() + " to " + request.destination());
            selectedCar.setAvailability(false);
            trip.completeTrip();

            updateStatistics(request, selectedDriver);
        }
    }

    private void updateStatistics(CargoRequest request, Driver driver) {
        driverCargoWeight.put(driver, driverCargoWeight.get(driver) + request.weight());

        destinationCargoWeight.put(request.destination(),
                destinationCargoWeight.getOrDefault(request.destination(), 0.0) + request.weight());

        double earnings = driverEarnings.get(driver) + (request.weight() * 5);
        driverEarnings.put(driver, earnings);
    }

    private Driver selectDriver(CargoRequest request) {
        for (Driver driver : drivers) {
            if (driver.getExperience() >= 2) {
                return driver;
            }
        }
        return null;
    }

    private Car selectCar(CargoRequest request) {
        for (Car car : cars) {
            if (car.isAvailable() && car.getCapacity() >= request.weight()) {
                return car;
            }
        }
        return null;
    }

    public void printDriverStatistics() {
        System.out.println("Driver statistics:");
        for (Driver driver : drivers) {
            System.out.println(driver.getName() + ": " + driverCargoWeight.get(driver) + " kg of cargo, Earnings: " + driverEarnings.get(driver) + " UAH");
        }
    }

    public void printDestinationStatistics() {
        System.out.println("Destination statistics:");
        for (Map.Entry<String, Double> entry : destinationCargoWeight.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " kg");
        }
    }

    public void printTopEarners() {
        System.out.println("Top earners:");
        driverEarnings.entrySet()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey().getName() + ": " + entry.getValue() + " UAH"));
    }
}
