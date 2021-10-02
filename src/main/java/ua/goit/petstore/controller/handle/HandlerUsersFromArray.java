package ua.goit.petstore.controller.handle;

public class HandlerUsersFromArray extends PetShopHandler{

    public HandlerUsersFromArray(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {

    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("3".equals(inputNumber) || consoleLevel.equals("Pets"));
    }
}
