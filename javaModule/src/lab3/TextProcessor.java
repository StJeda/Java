package lab3;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class TextProcessor {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Оберіть джерело тексту: " +
                "введіть '1' для введення вручну " +
                "або '2' для читання з файлу.");
        int choice = scanner.nextInt();

        scanner.nextLine();

        String text;

        if (choice == 1) {
            System.out.println("Введіть текст:");
            text = scanner.nextLine();
        } else {
            System.out.println("Введіть шлях до файлу:");
            String filePath = scanner.nextLine();
            text = new String(Files.readAllBytes(new File(filePath).toPath()));
        }

        int wordCount = text.split("\\s+").length;
        int sentenceCount = text.split("[.!?]+\\s*").length;

        String formattedText = Arrays.stream(text.split("\\s+")).map(word -> {

            if (word.length() > 1 && Character.toLowerCase(word.charAt(0)) == Character.toLowerCase(word.charAt(word.length() - 1))) {
                return word.toUpperCase();
            }

            return word;
        }).collect(Collectors.joining(" "));

        String[] lines = text.split("\\r?\\n");

        String longestLine = Arrays.stream(lines).max(Comparator.comparingInt(String::length)).orElse("");
        formattedText += "\n" + longestLine;

        List<String> words = Arrays.asList(formattedText.split("\\s+"));
        int maxWordLength = words.stream().mapToInt(String::length).max().orElse(0);
        formattedText = words.stream().map(word -> {
            if (word.length() == maxWordLength) {
                return "*".repeat(maxWordLength) + " (довге слово)";
            }
            return word;
        }).collect(Collectors.joining(" "));

        System.out.println("Кількість слів: " + wordCount);
        System.out.println("Кількість речень: " + sentenceCount);
        System.out.println("Перетворений текст:");
        System.out.println(formattedText);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("Кількість слів: " + wordCount + "\n");
            writer.write("Кількість речень: " + sentenceCount + "\n");
            writer.write("Перетворений текст:\n");
            writer.write(formattedText);
        }

        System.out.println("Результат збережено у файл output.txt");
    }
}
