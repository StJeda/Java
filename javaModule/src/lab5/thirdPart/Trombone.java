package lab5.thirdPart;

public class Trombone extends MusicalAbstraction {
    public Trombone() {
        super("Trombone", "A brass instrument with a telescoping slide.");
    }

    @Override
    public String sound() {
        return "Bold and resonant sound.";
    }

    @Override
    public void history() {
        System.out.println("Evolved from the sackbut in the 15th century.");
    }
}