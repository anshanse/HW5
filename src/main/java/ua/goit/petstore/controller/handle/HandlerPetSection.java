package ua.goit.petstore.controller.handle;

public class HandlerPetSection extends PetShopHandler{

    public HandlerPetSection(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        consoleLevel = "Pet";
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("1".equals(inputNumber) && "Upper".equals(consoleLevel));
    }
}
