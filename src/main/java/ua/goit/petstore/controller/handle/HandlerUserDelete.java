package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.Order;
import ua.goit.petstore.model.User;

public class HandlerUserDelete extends PetShopHandler{

    public HandlerUserDelete(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        message.sendMessage("Input order ID:");
        Long id = Long.valueOf(readData.readConsole());
        User entity = userService.delete(id);
        message.operationEntityMgs("deleted", Order.class, entity);
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("8".equals(inputNumber) && consoleLevel.equals("User"));
    }
}
