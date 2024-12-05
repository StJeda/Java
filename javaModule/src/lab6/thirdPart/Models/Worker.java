package lab6.thirdPart.Models;

import lab6.thirdPart.Abstractions.IPart;
import lab6.thirdPart.Abstractions.IWorker;

public class Worker implements IWorker {
    @Override
    public void work(HouseFacade house) {
        for (IPart part : house.getParts()) {
            if (!part.isBuilt()) {
                part.build();
                System.out.println("Worker built: " + part.getName());
                break;
            }
        }
    }
}
