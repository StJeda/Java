public static void main() {
    Scanner scanner = new Scanner(System.in);

    Map<String, Integer> menu = new LinkedHashMap<>();
    menu.put("Кава", 10);
    menu.put("Чай", 5);
    menu.put("Кекс", 15);
    menu.put("Пиріжок", 7);

    System.out.print("Скільки людей у компанії? ");
    int numPeople = scanner.nextInt();
    int totalCost = 0;

    for (int i = 1; i <= numPeople; i++) {
        System.out.println("\nМеню для людини " + i + ":");
        int personTotal = processOrder(menu, scanner);
        totalCost += personTotal;
        System.out.println("Загальна вартість для людини " + i + ": " + personTotal + " грн");
    }

    System.out.println("\nЗагальна вартість замовлення для компанії: " + totalCost + " грн");
}

private static int processOrder(Map<String, Integer> menu, Scanner scanner) {
    int personTotal = 0;
    boolean moreItems = true;

    while (moreItems) {
        displayMenu(menu);
        System.out.print("Виберіть позицію (1-" + menu.size() + "), щоб додати до замовлення, або 0 для завершення: ");
        int choice = getValidChoice(scanner, menu.size());

        if (choice == 0) {
            moreItems = false;
        } else {
            String selectedItem = getItemByChoice(menu, choice);
            personTotal += menu.get(selectedItem);
            System.out.println("Вибрано: "
                    + selectedItem + " - "
                    + menu.get(selectedItem)
                    + " грн");
        }
    }

    return personTotal;
}

private static void displayMenu(Map<String, Integer> menu) {
    System.out.println("\nМеню:");
    int index = 1;
    for (Map.Entry<String, Integer> entry : menu.entrySet()) {
        System.out.println(index + ". "
                + entry.getKey() + " - "
                + entry.getValue() + " грн");
        index++;
    }
}

private static int getValidChoice(Scanner scanner, int maxChoice) {
    int choice;
    while (true) {
        choice = scanner.nextInt();
        if (choice >= 0 && choice <= maxChoice) {
            break;
        } else {
            System.out.print("Невірний вибір. Спробуйте ще раз: ");
        }
    }
    return choice;
}

private static String getItemByChoice(Map<String, Integer> menu, int choice) {
    int index = 1;
    for (String item : menu.keySet()) {
        if (index == choice) {
            return item;
        }
        index++;
    }
    return null;
}
