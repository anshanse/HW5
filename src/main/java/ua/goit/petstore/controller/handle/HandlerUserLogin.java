package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.ApiResponse;

public class HandlerUserLogin extends PetShopHandler{

    public HandlerUserLogin(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        message.sendMessage("Input user name:");
        String name = readData.readConsole();
        System.out.println("Input user password:");
        String pass = readData.readConsole();
        ApiResponse loginResponse = userService.login(name, pass);
        message.apiResponseMsg(loginResponse, "User logged", "");
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("6".equals(inputNumber) && consoleLevel.equals("User"));
    }
}
