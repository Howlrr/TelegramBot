package TBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyMarsBot extends TelegramLongPollingBot {

    private MarsStorage storage;

    public MyMarsBot(MarsStorage storage) {
        this.storage = storage;
    }

    @Override
    public String getBotUsername() {
        return "7777777777777";
    }

    @Override
    public String getBotToken() {
        return ".........................";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equals("/status")) {
                String report = "🛰️ Отчет со склада:\n" + storage.getInventory().toString();
                sendMessage(chatId, report);
            } else {
                sendMessage(chatId, "Я тебя понял, но пока умею только /status");
            }
        }
    }

    private void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
