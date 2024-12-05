package lab5.thirdPart;

public class Cello extends MusicalAbstraction {
    public Cello() {
        super("Cello", "A large string instrument with a deep sound.");
    }

    @Override
    public String sound() {
        return "Rich and warm sound.";
    }

    @Override
    public void history() {
        System.out.println("Developed in the 16th century in Italy.");
    }
}
