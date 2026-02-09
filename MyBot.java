package TBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyMarsBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "Maven_forceBot";
    }

    @Override
    public String getBotToken() {
        return "8524182325:AAFUjPyKSQRHejAPh5UnCp0J877mowXBbDk";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String receivedText = update.getMessage().getText();

            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chatId));
            message.setText("🚀 Сигнал получен! Вы сказали: " + receivedText);

            try {
                execute(message); 
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
