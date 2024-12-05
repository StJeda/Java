package lab7;

import java.util.*;

public class CafeQueue {
    private static final Queue<Visitor> queue = new PriorityQueue<>(Comparator.comparing(Visitor::priority).reversed());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Додати відвідувача");
            System.out.println("2. Обслуговування відвідувача");
            System.out.println("3. Вийти");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline
            switch (choice) {
                case 1: addVisitor(); break;
                case 2: serveVisitor(); break;
                case 3: return;
                default: System.out.println("Невірний вибір, спробуйте ще раз."); break;
            }
        }
    }

    private static void addVisitor() {
        System.out.print("Введіть ім'я відвідувача: ");
        String name = scanner.nextLine();
        System.out.print("Зарезервував столик (так/ні)? ");
        boolean isReserved = scanner.nextLine().equalsIgnoreCase("так");
        Visitor visitor = new Visitor(name, isReserved ? 1 : 0);
        queue.offer(visitor);
        System.out.println("Відвідувача додано.");
    }

    private static void serveVisitor() {
        if (!queue.isEmpty()) {
            Visitor visitor = queue.poll();
            System.out.println("Обслуговування відвідувача: " + visitor.name());
        } else {
            System.out.println("Черга порожня.");
        }
    }
}
