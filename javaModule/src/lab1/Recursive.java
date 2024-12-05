public static int findMin() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введіть число (0 або <= 9 для завершення): ");
    int number = scanner.nextInt();

    if (number <= 9) {
        return Integer.MAX_VALUE;
    }

    int minOfRest = findMin();

    return Math.min(number, minOfRest);
}

public static void main() {
    System.out.println("Знайдемо мінімальне число серед введених.");

    int minValue = findMin();

    if (minValue == Integer.MAX_VALUE) {
        System.out.println("Не було введено жодного числа більше 9.");
    } else {
        System.out.println("Мінімальне число: " + minValue);
    }
}
