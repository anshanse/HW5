package ua.goit.petstore.controller.handle;

public class HandlerUserDelete extends PetShopHandler{

    public HandlerUserDelete(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        //...
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("8".equals(inputNumber) || consoleLevel.equals("User"));
    }
}
