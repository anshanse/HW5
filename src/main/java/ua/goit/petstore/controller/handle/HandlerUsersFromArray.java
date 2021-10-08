package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.User;

import java.util.List;

public class HandlerUsersFromArray extends PetShopHandler{

    public HandlerUsersFromArray(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        message.sendMessage("Input users (for stop type exit)");
        List<User> users = userService.readUsersToList();
        User[] userArray = userService.listToArray(users);
        ApiResponse fromListResponse = userService.createFromArray(userArray);
        message.apiResponseMsg(fromListResponse, "Users created", "Users not created");
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("2".equals(inputNumber) && consoleLevel.equals("User"));
    }
}
