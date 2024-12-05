package lab5.secondPart;

public class Wolf extends Animal {
    public Wolf() {
        super("Wolf", true);
    }

    @Override
    public String makeSound() {
        return "Howl!";
    }
}
