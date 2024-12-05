package lab6.firstPart;

import java.io.*;
import java.util.Arrays;

public class Geometry implements Serializable, Comparable<Geometry> {
    private static int calculationCount = 0;
    private final double value;

    public Geometry(double value) {
        this.value = value;
    }

    public static double calculateTriangleArea(double base, double height) {
        calculationCount++;
        return 0.5 * base * height;
    }

    public static double calculateRectangleArea(double width, double height) {
        calculationCount++;
        return width * height;
    }

    public static double calculateSquareArea(double side) {
        calculationCount++;
        return side * side;
    }

    public static double calculateRhombusArea(double diagonal1, double diagonal2) {
        calculationCount++;
        return 0.5 * diagonal1 * diagonal2;
    }

    public static int getCalculationCount() {
        return calculationCount;
    }

    public double getValue() {
        return value;
    }

    @Override
    public int compareTo(Geometry other) {
        return Double.compare(this.value, other.value);
    }

    public static void saveObjectsToFile(Geometry[] objects, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(objects);
        }
    }

    public static Geometry[] loadObjectsFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Geometry[]) ois.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Geometry[] geometries = {
                new Geometry(calculateTriangleArea(3, 4)),
                new Geometry(calculateRectangleArea(5, 6)),
                new Geometry(calculateSquareArea(7)),
                new Geometry(calculateRhombusArea(8, 9))
        };

        Arrays.sort(geometries);

        for (Geometry geometry : geometries) {
            System.out.println("Value: " + geometry.getValue());
        }

        String filePath = "geometries.dat";
        saveObjectsToFile(geometries, filePath);
        Geometry[] loadedGeometries = loadObjectsFromFile(filePath);

        System.out.println("Loaded objects:");
        for (Geometry geometry : loadedGeometries) {
            System.out.println("Value: " + geometry.getValue());
        }
    }
}
