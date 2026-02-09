package TBot;


import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class BotLogic {
    public static void main(String[] args) {
        MarsStorage myStorage = new MarsStorage();
        Main.fileManager manager = new Main.fileManager();
        manager.loadThis(myStorage);

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            botsApi.registerBot(new MyMarsBot(myStorage));

            System.out.println("🤖 Бот-завсклад запущен!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
