package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.User;

public class HandlerUserCreate extends PetShopHandler{

    public HandlerUserCreate(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        User entity = userService.create(User.class);
        ApiResponse saveResponse =userService.save(entity);
        message.apiResponseMsg(saveResponse,"User created","");
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("1".equals(inputNumber) && consoleLevel.equals("User"));
    }
}
