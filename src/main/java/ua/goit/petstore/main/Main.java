package ua.goit.petstore.main;

import lombok.SneakyThrows;
import ua.goit.petstore.controller.handle.HandlerExit;
import ua.goit.petstore.controller.handle.PetShopHandler;
import ua.goit.petstore.util.MessageService;
import ua.goit.petstore.util.ReadData;

public class Main {


    @SneakyThrows
    public static void main(String[] args) {

        PetShopHandler handler = PetShopHandler.of();
        MessageService message = new MessageService();
        ReadData readData = new ReadData();

        while (!HandlerExit.isExit) {
            message.levelMessage();
            handler.handle(readData.readConsole());
        }
    }
}
