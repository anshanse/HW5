package ua.goit.petstore.controller.handle;

public class HandlerUserCreate extends PetShopHandler{

    public HandlerUserCreate(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {

    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("4".equals(inputNumber) || consoleLevel.equals("Pets"));
    }
}
