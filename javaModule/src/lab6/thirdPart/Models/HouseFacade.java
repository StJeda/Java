package lab6.thirdPart.Models;
import java.util.Arrays;
import java.util.List;
import lab6.thirdPart.Abstractions.IPart;

public class HouseFacade {
    private final List<IPart> parts;

    public HouseFacade() {
        parts = Arrays.asList(
                new Basement(),
                new Wall(),
                new Wall(),
                new Wall(),
                new Wall(),
                new Door(),
                new Window(),
                new Window(),
                new Window(),
                new Window(),
                new Roof()
        );
    }

    public List<IPart> getParts() {
        return parts;
    }

    public boolean isBuilt() {
        return parts.stream().allMatch(IPart::isBuilt);
    }
}