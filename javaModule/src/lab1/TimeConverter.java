public static void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введіть кількість годин: ");
    int hours = scanner.nextInt();

    String greeting = switch (hours) {
        case int h when (h >= 0 && h < 6) -> "Час не їсти";
        case int h when (h >= 6 && h < 13) -> "Час завтракати";
        case int h when (h >= 13 && h < 17) -> "Час обіду";
        case int h when (h >= 17 && h < 24) -> "Час вечері";
        default -> "Невірна кількість годин.";
    };

    System.out.println(greeting);
}