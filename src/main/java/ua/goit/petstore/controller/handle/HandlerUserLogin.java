package ua.goit.petstore.controller.handle;

public class HandlerUserLogin extends PetShopHandler{

    public HandlerUserLogin(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        //...
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("6".equals(inputNumber) || consoleLevel.equals("User"));
    }
}
