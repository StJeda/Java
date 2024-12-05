package Domain.Models.Autobase;

public class Trip {
    private final Driver driver;
    private final Car car;
    private final CargoRequest cargoRequest;
    private boolean isCompleted;

    public Trip(Driver driver, Car car, CargoRequest cargoRequest) {
        this.driver = driver;
        this.car = car;
        this.cargoRequest = cargoRequest;
        this.isCompleted = false;
    }

    public void completeTrip() {
        double earnings = cargoRequest.weight() * 5;
        driver.addEarnings(earnings);

        System.out.println("Trip completed for " + driver.getName() + " to " + cargoRequest.destination());
        System.out.println("Driver earned: " + earnings + " UAH");

        car.setAvailability(true);
        isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}

