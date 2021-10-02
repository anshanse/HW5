package ua.goit.petstore.controller.handle;

import ua.goit.petstore.service.PetService;

public class HandlerPetUpdate extends PetShopHandler{

    private PetService service = new PetService();

    public HandlerPetUpdate(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        //...
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("3".equals(inputNumber) && consoleLevel.equals("Pets"));
    }
}
