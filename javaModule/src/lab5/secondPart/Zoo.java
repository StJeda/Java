package lab5.secondPart;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private final List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public long countPredators() {
        return animals.stream().filter(Animal::isPredator).count();
    }

    public int calculateFoodDemand() {
        return animals.stream()
                .mapToInt(animal -> animal.isPredator() ? 10 : 5)
                .sum();
    }
}
