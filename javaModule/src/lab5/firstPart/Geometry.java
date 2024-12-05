package lab5;

public class Geometry {
    private static int calculationCount = 0;

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
}