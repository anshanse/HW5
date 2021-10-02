package ua.goit.petstore.controller.handle;

public class HandlerExit extends PetShopHandler{

    public HandlerExit() {
        super(null);
    }

    public static boolean isExit = false;

    @Override
    protected void apply() {
        if (!"Upper".equals(consoleLevel)) {
            consoleLevel = "Upper";
        }
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("0".equals(inputNumber));
    }
}
