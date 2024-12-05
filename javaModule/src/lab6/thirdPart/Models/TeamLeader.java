package lab6.thirdPart.Models;

import lab6.thirdPart.Abstractions.IPart;
import lab6.thirdPart.Abstractions.IWorker;

public class TeamLeader implements IWorker {
    @Override
    public void work(HouseFacade house) {
        long builtParts = house.getParts()
                .stream()
                .filter(IPart::isBuilt)
                .count();
        System.out.println("TeamLeader report: "
                + builtParts
                + "/"
                + house.getParts().size()
                + " parts built.");
    }
}
