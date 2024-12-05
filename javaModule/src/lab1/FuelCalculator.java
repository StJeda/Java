public static void main() {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Введіть ємність бака літака (літри): ");
    int fuelCapacity = scanner.nextInt();

    System.out.print("Введіть відстань між пунктами А і В (км): ");
    int distanceAB = scanner.nextInt();

    System.out.print("Введіть відстань між пунктами В і С (км): ");
    int distanceBC = scanner.nextInt();

    System.out.print("Введіть вагу вантажу (кг): ");
    int weight = scanner.nextInt();

    try {
        int litterPerKm = switch (weight) {
            case int w when (w <= 500) -> 1;
            case int w when (w <= 1000) -> 4;
            case int w when (w <= 1500) -> 7;
            case int w when (w <= 2000) -> 9;
            default -> throw new IllegalArgumentException("Літак не може підняти вантаж.");
        };

        int needFuel = (distanceAB + distanceBC) * litterPerKm;

        if (needFuel > fuelCapacity) {
            System.out.println("Неможливо здійснити політ.");
        } else {
            System.out.println("Необхідно дозаправити " + (needFuel - fuelCapacity) + " літрів.");
        }
    }
    catch(Exception ex) {
        System.out.println(ex.getMessage());
    }
}
