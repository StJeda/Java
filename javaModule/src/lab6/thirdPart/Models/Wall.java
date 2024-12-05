package lab6.thirdPart.Models;

import lab6.thirdPart.Abstractions.IPart;

public class Wall implements IPart {
    private boolean built = false;

    @Override
    public String getName() {
        return "Wall";
    }

    @Override
    public boolean isBuilt() {
        return built;
    }

    @Override
    public void build() {
        built = true;
    }
}
