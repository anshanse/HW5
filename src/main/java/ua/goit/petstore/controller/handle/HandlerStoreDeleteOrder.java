package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.Order;

public class HandlerStoreDeleteOrder extends PetShopHandler{

    public HandlerStoreDeleteOrder(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        message.sendMessage("Input order ID:");
        Long id = Long.valueOf(readData.readConsole());
        Order entity = storeService.delete(id);
        message.operationEntityMgs("deleted", Order.class, entity);
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("4".equals(inputNumber) && consoleLevel.equals("Store"));
    }
}
