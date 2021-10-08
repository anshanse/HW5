package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.Order;

public class HandlerStoreNewOrder extends PetShopHandler{

    public HandlerStoreNewOrder(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        Order entity = storeService.create(Order.class);
        Order savedEntity = storeService.save(entity);
        message.operationEntityMgs("created", Order.class, savedEntity);
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("2".equals(inputNumber) && consoleLevel.equals("Store"));
    }
}
