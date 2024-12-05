package lab5.secondPart;

public class Rabbit extends Animal {
    public Rabbit() {
        super("Rabbit", false);
    }

    @Override
    public String makeSound() {
        return "Squeak!";
    }
}