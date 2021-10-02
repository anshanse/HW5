package ua.goit.petstore.controller.handle;

public class HandlerUsersFromList extends PetShopHandler{

    public HandlerUsersFromList(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        //...
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("3".equals(inputNumber) || consoleLevel.equals("User"));
    }
}
