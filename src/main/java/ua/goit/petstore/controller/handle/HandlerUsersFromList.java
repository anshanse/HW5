package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.User;

import java.util.List;

public class HandlerUsersFromList extends PetShopHandler{

    public HandlerUsersFromList(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        message.sendMessage("Input users (for stop type exit)");
        List<User> users = userService.readUsersToList();
        ApiResponse fromListResponse = userService.createFromList(users);
        message.apiResponseMsg(fromListResponse, "Users created", "Users not created");
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("3".equals(inputNumber) && consoleLevel.equals("User"));
    }
}
