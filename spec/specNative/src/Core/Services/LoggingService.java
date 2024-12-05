package Core.Services;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggingService {
    private static final String LOG_FILE = "log.txt";

    public static void logTrip(String message) {
        try (FileWriter fileWriter = new FileWriter(LOG_FILE, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(message);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}

