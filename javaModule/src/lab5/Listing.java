package lab5;

import lab5.secondPart.*;
import lab5.thirdPart.MusicalAbstraction;
import lab5.thirdPart.Ukulele;

public class Listing {
    public static void main() {
        System.out.println("Square area: " + lab5.Geometry.calculateSquareArea(5));
        System.out.println("Total calculations: " + lab5.Geometry.getCalculationCount());

        var zoo = new Zoo();
        zoo.addAnimal(new Tiger());
        zoo.addAnimal(new Rabbit());
        zoo.addAnimal(new Wolf());
        zoo.addAnimal(new Kangaroo());

        System.out.println("Predators count: " + zoo.countPredators());
        System.out.println("Total food demand: " + zoo.calculateFoodDemand() + " kg");

        MusicalAbstraction ukulele = new Ukulele();
        ukulele.show();
        ukulele.desc();
        System.out.println("Sound: " + ukulele.sound());
        ukulele.history();
    }
}
