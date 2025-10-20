package ki305.vladyka.lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Клас Logger відповідає за логування дій у файл log.txt.
 */
class Logger {
    private static final String LOG_FILE = "log.txt";

    /**
     * Записує повідомлення у лог-файл з міткою часу.
     * @param message Повідомлення для логування
     */
    static void log(String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write("[" + LocalDateTime.now() + "] " + message + "\n");
        } catch (IOException e) {
            System.out.println("Помилка запису в лог: " + e.getMessage());
        }
    }
}
