package lab5.thirdPart;

public class Violin extends MusicalAbstraction {
    public Violin() {
        super("Violin", "A string instrument played with a bow.");
    }

    @Override
    public String sound() {
        return "Soft and melodic sound.";
    }

    @Override
    public void history() {
        System.out.println("Originated in Italy in the 16th century.");
    }
}
