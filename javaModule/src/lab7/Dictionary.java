package lab7;

import java.util.*;

public class Dictionary {
    private static final Map<String, List<String>> dictionary = new HashMap<>();
    private static final Map<String, Integer> wordCount = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        dictionary.put("hello", new ArrayList<>(Arrays.asList("hola", "saluton")));
        dictionary.put("world", new ArrayList<>(List.of("mundo")));
        wordCount.put("hello", 10);
        wordCount.put("world", 5);

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: addWord(); break;
                case 2: replaceTranslation(); break;
                case 3: removeWord(); break;
                case 4: top10Words(); break;
                case 5: return;
                default: System.out.println("Невірний вибір, спробуйте ще раз."); break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("Меню:");
        System.out.println("1. Додати нове слово");
        System.out.println("2. Заміна перекладу слова");
        System.out.println("3. Видалити слово");
        System.out.println("4. Топ-10 популярних слів");
        System.out.println("5. Вийти");
    }

    private static void addWord() {
        System.out.print("Введіть слово: ");
        String word = scanner.nextLine();
        System.out.print("Введіть переклад: ");
        String translation = scanner.nextLine();
        dictionary.putIfAbsent(word, new ArrayList<>());
        dictionary.get(word).add(translation);
        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        System.out.println("Слово додано.");
    }

    private static void replaceTranslation() {
        System.out.print("Введіть слово: ");
        String word = scanner.nextLine();
        if (dictionary.containsKey(word)) {
            System.out.print("Введіть новий переклад: ");
            String newTranslation = scanner.nextLine();
            dictionary.get(word).set(0, newTranslation);
            System.out.println("Переклад замінено.");
        } else {
            System.out.println("Слово не знайдено.");
        }
    }

    private static void removeWord() {
        System.out.print("Введіть слово для видалення: ");
        String word = scanner.nextLine();
        if (dictionary.remove(word) != null) {
            wordCount.remove(word);
            System.out.println("Слово видалено.");
        } else {
            System.out.println("Слово не знайдено.");
        }
    }

    private static void top10Words() {
        List<String> topWords = wordCount.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Топ-10 популярних слів:");
        topWords.forEach(System.out::println);
    }
}
