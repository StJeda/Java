package lab5.secondPart;

public class Maksym extends Animal {
    public Maksym() {
        super("Maksym", false);
    }

    @Override
    public String makeSound() {
        return "Time to make a bit of perfomance!";
    }
}
