package lab8.Tests;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static lab8.TaskSearch.removeForbiddenWords;
import static lab8.TaskSearch.searchAndMergeFiles;

public class TaskSearchTest {
    public static void main() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter directory path:");
            String dirPath = scanner.nextLine();

            System.out.println("Enter word to search:");
            String searchWord = scanner.nextLine();

            ExecutorService executor = Executors.newFixedThreadPool(2);

            try {
                Future<Void> searchAndMergeFuture = executor.submit(() -> {
                    try {
                        searchAndMergeFiles(dirPath, searchWord);
                    } catch (IOException e) {
                        System.err.println("Error during file search and merge operation: " + e.getMessage());
                    }
                    return null;
                });

                Future<Void> removeForbiddenWordsFuture = executor.submit(() -> {
                    try {
                        removeForbiddenWords();
                    } catch (IOException e) {
                        System.err.println("Error during forbidden words removal: " + e.getMessage());
                    }
                    return null;
                });

                searchAndMergeFuture.get();
                removeForbiddenWordsFuture.get();

                System.out.println("Operations completed successfully.");
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error executing tasks: " + e.getMessage());
            } finally {
                executor.shutdown();
            }
        }
    }
}
