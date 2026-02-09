package TBot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        MarsStorage storage = new MarsStorage();
        fileManager manager = new fileManager();
        manager.loadThis(storage);

        storage.printInventory();

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            botsApi.registerBot(new MyMarsBot(storage));

            System.out.println("🤖 Бот успешно запущен!");
        } catch (Exception e) {
            System.out.println("❌ Ошибка запуска: " + e.getMessage());
        }
    }

    public static class fileManager {
        private String fileName = "SavedMars.txt";

        public void saveThis(MarsStorage storage) {
            var data = storage.getInventory();
            try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
                for (var entry : data.entrySet()) {
                    out.println(entry.getKey() + ":" + entry.getValue());
                }
            } catch (IOException e) {
                System.out.println("Ошибка записи: " + e.getMessage());
            }
        }

        public void loadThis(MarsStorage storage) {
            File file = new File(fileName);
            if (!file.exists()) return;
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        storage.addResource(parts[0], Integer.parseInt(parts[1]));
                    }
                }
            } catch (Exception e) {
                System.out.println("Ошибка загрузки: " + e.getMessage());
            }
        }
    }
}
