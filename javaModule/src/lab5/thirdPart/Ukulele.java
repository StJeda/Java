package lab5.thirdPart;

public class Ukulele extends MusicalAbstraction {
    public Ukulele() {
        super("Ukulele", "A small, guitar-like string instrument.");
    }

    @Override
    public String sound() {
        return "Light and cheerful sound.";
    }

    @Override
    public void history() {
        System.out.println("Introduced in Hawaii in the 19th century.");
    }
}
