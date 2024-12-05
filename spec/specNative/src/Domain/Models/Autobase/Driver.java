package Domain.Models.Autobase;

public class Driver {
    private final String name;
    private final int experience;
    private double earnings;

    public Driver(String name, int experience) {
        this.name = name;
        this.experience = experience;
        this.earnings = 0;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public double getEarnings() {
        return earnings;
    }

    public void addEarnings(double amount) {
        this.earnings += amount;
    }
}
