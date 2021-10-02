package ua.goit.petstore.controller.handle;

import ua.goit.petstore.service.PetService;

public class HandlerPetUpdateById extends PetShopHandler{

    private PetService service = new PetService();

    public HandlerPetUpdateById(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        //...
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("4".equals(inputNumber) && consoleLevel.equals("Pets"));
    }
}
