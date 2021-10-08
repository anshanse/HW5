package ua.goit.petstore.controller.handle;

public class HandlerOutOfSelection extends PetShopHandler{
    public HandlerOutOfSelection(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        message.inputCorrectData();
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        String acceptSelect = "";
        if ("Pets".equals(consoleLevel)){
            acceptSelect = "[^01234567]";
        }
        if ("Store".equals(consoleLevel)){
            acceptSelect = "[^01234]";
        }
        if ("User".equals(consoleLevel)){
            acceptSelect = "[^012345678]";
        }
        if ("Upper".equals(consoleLevel)){
            acceptSelect = "[^0123]";
        }
        return (inputNumber.matches(acceptSelect));
    }
}
