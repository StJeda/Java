package lab8;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class TaskSearch {
    public static void searchAndMergeFiles(String dirPath, String searchWord) throws IOException {
        Path dir = Paths.get(dirPath);
        File mergedFile = new File("merged.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(mergedFile))) {
            Files.walk(dir)
                    .filter(path -> Files.isRegularFile(path) && path.toString().endsWith(".txt"))
                    .forEach(path -> processFileForSearch(path, searchWord, writer));
        }
    }

    public static void processFileForSearch(Path path, String searchWord, BufferedWriter writer) {
        try {
            List<String> lines = Files.readAllLines(path);
            if (lines.stream().anyMatch(line -> line.contains(searchWord))) {
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error processing file: " + path);
        }
    }

    public static void removeForbiddenWords() throws IOException {
        File forbiddenFile = new File("forbidden_words.txt");
        Set<String> forbiddenWords = loadForbiddenWords(forbiddenFile);

        File mergedFile = new File("merged.txt");
        File tempFile = new File("merged_temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(mergedFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String filteredLine = filterForbiddenWords(line, forbiddenWords);
                writer.write(filteredLine);
                writer.newLine();
            }
        }

        if (tempFile.renameTo(mergedFile)) {
            System.out.println("Forbidden words removed successfully.");
        } else {
            System.err.println("Error renaming temp file to merged file.");
        }
    }

    public static Set<String> loadForbiddenWords(File forbiddenFile) throws IOException {
        if (!forbiddenFile.exists()) {
            System.err.println("Forbidden words file not found.");
            return Collections.emptySet();
        }

        return new HashSet<>(Files.readAllLines(forbiddenFile.toPath()));
    }

    public static String filterForbiddenWords(String line, Set<String> forbiddenWords) {
        return Arrays.stream(line.split(" "))
                .filter(word -> !forbiddenWords.contains(word))
                .collect(Collectors.joining(" "));
    }
}
