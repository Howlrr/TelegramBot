package TBot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class BotLogic {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
          
            botsApi.registerBot(new MyMarsBot());

            System.out.println("🤖 Бот запущен! Можно писать ему в Телеграм.");
        } catch (Exception e) {
            System.out.println("❌ Ошибка при запуске: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
