package ua.goit.petstore.controller.handle;

public class HandlerUserSection extends PetShopHandler{

    public HandlerUserSection(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        consoleLevel = "User";
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("3".equals(inputNumber) && "Upper".equals(consoleLevel));
    }
}
