package lab9;

public class GeometryShapes {

    public static double calculateTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    public static double calculateRectangleArea(double length, double width) {
        return length * width;
    }

    public static double calculateSquareArea(double side) {
        return side * side;
    }

    public static double calculateRhombusArea(double diagonal1, double diagonal2) {
        return 0.5 * diagonal1 * diagonal2;
    }
}