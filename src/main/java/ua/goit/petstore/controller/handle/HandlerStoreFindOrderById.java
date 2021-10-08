package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.Order;

public class HandlerStoreFindOrderById extends PetShopHandler{

    public HandlerStoreFindOrderById(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        message.sendMessage("Input order ID:");
        Long id = Long.valueOf(readData.readConsole());
        Order entity = storeService.findById(id);
        message.operationEntityMgs("find", Order.class, entity);
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("3".equals(inputNumber) && consoleLevel.equals("Store"));
    }
}
