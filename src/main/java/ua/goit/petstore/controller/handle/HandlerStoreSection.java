package ua.goit.petstore.controller.handle;

public class HandlerStoreSection extends PetShopHandler{

    public HandlerStoreSection(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        consoleLevel = "Store";
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("1".equals(inputNumber) && "Upper".equals(consoleLevel));
    }
}
