package ua.goit.petstore.controller.handle;

public class HandlerUserUpdate extends PetShopHandler{

    public HandlerUserUpdate(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        //...
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("4".equals(inputNumber) || consoleLevel.equals("User"));
    }
}
