package ua.goit.petstore.controller.handle;

public class HandlerStoreNewOrder extends PetShopHandler{

    public HandlerStoreNewOrder(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {

    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("3".equals(inputNumber) || consoleLevel.equals("Store"));
    }
}
