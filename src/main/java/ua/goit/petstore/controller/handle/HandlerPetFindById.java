package ua.goit.petstore.controller.handle;

import ua.goit.petstore.service.PetService;

public class HandlerPetFindById extends PetShopHandler{

    private PetService service = new PetService();

    public HandlerPetFindById(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        //...
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("5".equals(inputNumber) && consoleLevel.equals("Pets"));
    }
}
