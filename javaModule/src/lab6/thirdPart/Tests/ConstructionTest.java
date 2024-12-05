package lab6.thirdPart.Tests;

import lab6.thirdPart.Abstractions.IWorker;
import lab6.thirdPart.Models.HouseFacade;
import lab6.thirdPart.Models.TeamLeader;
import lab6.thirdPart.Models.Worker;

public class ConstructionTest {
    public static void main() {
        HouseFacade house = new HouseFacade();
        IWorker worker = new Worker();
        IWorker teamLeader = new TeamLeader();

        while (!house.isBuilt()) {
            worker.work(house);
            teamLeader.work(house);
        }

        System.out.println("Будівництво завершено!");
    }
}