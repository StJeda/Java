package lab5.thirdPart;

public abstract class MusicalAbstraction {
    private final String name;
    private final String description;

    public MusicalAbstraction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract String sound();

    public void show() {
        System.out.println("Instrument: " + name);
    }

    public void desc() {
        System.out.println("Description: " + description);
    }

    public abstract void history();
}
