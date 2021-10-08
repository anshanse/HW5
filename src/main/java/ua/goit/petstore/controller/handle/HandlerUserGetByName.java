package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.User;

public class HandlerUserGetByName extends PetShopHandler{

    public HandlerUserGetByName(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        message.sendMessage("Input user name:");
        String name = readData.readConsole();
        User entity = userService.getByName(name);
        message.operationEntityMgs("found", User.class,entity);
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("5".equals(inputNumber) && consoleLevel.equals("User"));
    }
}
