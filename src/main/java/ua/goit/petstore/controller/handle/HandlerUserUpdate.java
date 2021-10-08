package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.User;

public class HandlerUserUpdate extends PetShopHandler{

    public HandlerUserUpdate(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        message.sendMessage("Input user name:");
        String name = readData.readConsole();
        User updatingUser = userService.create(User.class);
        ApiResponse updateResponse = userService.update(name, updatingUser);
        message.apiResponseMsg(updateResponse, "User updated", "");
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("4".equals(inputNumber) && consoleLevel.equals("User"));
    }
}
