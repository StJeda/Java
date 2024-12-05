package Domain.Models.Autobase;

public class Car {
    private final String model;
    private final double capacity;
    private boolean isAvailable;

    public Car(String model, double capacity) {
        this.model = model;
        this.capacity = capacity;
        this.isAvailable = true;
    }

    public String getModel() {
        return model;
    }

    public double getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }
}

