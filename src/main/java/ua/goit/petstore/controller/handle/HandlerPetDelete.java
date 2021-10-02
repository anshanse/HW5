package ua.goit.petstore.controller.handle;

import ua.goit.petstore.service.PetService;

public class HandlerPetDelete extends PetShopHandler{

    private PetService service = new PetService();

    public HandlerPetDelete(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        //...
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("7".equals(inputNumber) && consoleLevel.equals("Pets"));
    }
}
