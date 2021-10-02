package ua.goit.petstore.main;

import lombok.SneakyThrows;
import ua.goit.petstore.controller.handle.HandlerExit;
import ua.goit.petstore.controller.handle.PetShopHandler;
import ua.goit.petstore.util.MessageService;
import ua.goit.petstore.util.ReadData;

public class Main {

    //private static String urlPath = PropertiesLoader.getProperty("api.url");
    //private static long sleepTime = 1_500;

    @SneakyThrows
    public static void main(String[] args) {
        //RetrofitClientUser client = createClient(urlPath, GsonConverterFactory.create(), RetrofitClientUser.class);
        PetShopHandler handler = PetShopHandler.of();
        MessageService message = new MessageService();
        ReadData readData = new ReadData();

        while (!HandlerExit.isExit) {
            message.upperLevelMessage();
            handler.handle(readData.readConsole());
        }
    }
}
