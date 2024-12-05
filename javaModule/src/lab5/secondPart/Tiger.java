package lab5.secondPart;

public class Tiger extends Animal {
    public Tiger() {
        super("Tiger", true);
    }

    @Override
    public String makeSound() {
        return "Roar!";
    }
}