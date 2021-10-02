package ua.goit.petstore.controller.handle;

import ua.goit.petstore.service.PetService;

public class HandlerPetFindByStatus extends PetShopHandler{

    private PetService service = new PetService();

    public HandlerPetFindByStatus(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        //...
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("6".equals(inputNumber) && consoleLevel.equals("Pets"));
    }
}
