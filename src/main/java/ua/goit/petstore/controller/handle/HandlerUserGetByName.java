package ua.goit.petstore.controller.handle;

public class HandlerUserGetByName extends PetShopHandler{

    public HandlerUserGetByName(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        //...
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("5".equals(inputNumber) || consoleLevel.equals("User"));
    }
}
