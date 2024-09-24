package umg.Programacion2.BotTelegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "@Destruc10Bot";
    }

    @Override
    public String getBotToken() {
        return "7365041607:AAGoQgvMDx6MFhXhE0Gr1VHoVzurQxBeJio";
    }



    //El método onUpdateReceived(Update update) de la clase Bot se usa para manejar todas las actualizaciones que el
    // bot recibe.
    // Dependiendo del tipo de actualización, se toman diferentes acciones.

    @Override
    public void onUpdateReceived(Update update) {

String nombre = update.getMessage().getFrom().getFirstName();
String apellido = update.getMessage().getFrom().getLastName();
String nickName = update.getMessage().getFrom().getUserName();

        //Se verifica si la actualización contiene un mensaje y si ese mensaje tiene texto.
        //Luego se procesa el contenido del mensaje y se responde según el caso.
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            System.out.println("Hola" +nickName +"Tu Nombre es:" +nombre+"y tu Apellido es:" +apellido+ "message"+message_text);

            if (message_text.toLowerCase().equals("hola")){
                sendText(chat_id,"hola"+nombre+"gusto de saludar");
            }
        }
    }


    public void sendText(Long who, String what) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here}
        }
    }


} //endclass
