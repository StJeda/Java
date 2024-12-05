package lab5.secondPart;

public class Kangaroo extends Animal {
    public Kangaroo() {
        super("Kangaroo", false);
    }

    @Override
    public String makeSound() {
        return "Click!";
    }
}
