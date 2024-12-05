package Helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class CustomLogger {

    private static final Logger logger = Logger.getLogger(CustomLogger.class.getName());
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";

    static {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        consoleHandler.setFormatter(new CustomFormatter());
        logger.setLevel(Level.ALL);
    }

    // Логування повідомлень (успішних операцій)
    public static void logSuccess(String message) {
        logger.info(GREEN + message + RESET);
    }

    // Логування помилок
    public static void logError(String message) {
        logger.severe(message);
    }

    private static class CustomFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            StringBuilder sb = new StringBuilder();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sb.append(dateFormat.format(new Date(record.getMillis())))
                    .append(" ");

            sb.append(record.getMessage())
                    .append("\n");

            return sb.toString();
        }
    }
}
