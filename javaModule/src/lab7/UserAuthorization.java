package lab7;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class UserAuthorization {
    private static final Map<String, String> users = new HashMap<>();
    private static final Map<String, String> saltStore = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: addUser(); break;
                case 2: removeUser(); break;
                case 3: checkUser(); break;
                case 4: changeLogin(); break;
                case 5: changePassword(); break;
                case 6: return;
                default: System.out.println("Невірний вибір, спробуйте ще раз."); break;
            }
        }
    }

    private static void showMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("Меню:\n")
                .append("1. Додати нового користувача\n")
                .append("2. Видалити існуючого користувача\n")
                .append("3. Перевірити чи існує користувач\n")
                .append("4. Змінити логін користувача\n")
                .append("5. Змінити пароль користувача\n")
                .append("6. Вийти\n");
        System.out.println(menu.toString());
    }

    private static void addUser() {
        System.out.print("Введіть логін: ");
        String login = scanner.nextLine();
        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        users.put(login, hashedPassword);
        saltStore.put(login, salt);
        System.out.println("Користувача додано.");
    }

    private static void removeUser() {
        System.out.print("Введіть логін для видалення: ");
        String login = scanner.nextLine();
        if (users.remove(login) != null) {
            saltStore.remove(login);
            System.out.println("Користувача видалено.");
        } else {
            System.out.println("Користувач не знайдений.");
        }
    }

    private static void checkUser() {
        System.out.print("Введіть логін для перевірки: ");
        String login = scanner.nextLine();
        if (users.containsKey(login)) {
            System.out.println("Користувач існує.");
        } else {
            System.out.println("Користувач не знайдений.");
        }
    }

    private static void changeLogin() {
        System.out.print("Введіть старий логін: ");
        String oldLogin = scanner.nextLine();
        if (users.containsKey(oldLogin)) {
            System.out.print("Введіть новий логін: ");
            String newLogin = scanner.nextLine();
            String password = users.remove(oldLogin);
            String salt = saltStore.remove(oldLogin);
            users.put(newLogin, password);
            saltStore.put(newLogin, salt);
            System.out.println("Логін змінено.");
        } else {
            System.out.println("Користувач не знайдений.");
        }
    }

    private static void changePassword() {
        System.out.print("Введіть логін: ");
        String login = scanner.nextLine();
        if (users.containsKey(login)) {
            System.out.print("Введіть новий пароль: ");
            String newPassword = scanner.nextLine();
            String salt = generateSalt();
            String hashedPassword = hashPassword(newPassword, salt);
            users.put(login, hashedPassword);
            saltStore.put(login, salt);
            System.out.println("Пароль змінено.");
        } else {
            System.out.println("Користувач не знайдений.");
        }
    }

    private static String generateSalt() {
        return UUID.randomUUID().toString();
    }

    private static String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}
