package ua.goit.petstore.controller.handle;

public class HandlerUserLogout extends PetShopHandler{

    public HandlerUserLogout(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        //...
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("7".equals(inputNumber) || consoleLevel.equals("User"));
    }
}
