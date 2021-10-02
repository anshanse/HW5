package ua.goit.petstore.controller.handle;

import ua.goit.petstore.service.PetService;

public class HandlerPetUploadImg extends PetShopHandler{

    private PetService service = new PetService();

    public HandlerPetUploadImg(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        //...
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("2".equals(inputNumber) && consoleLevel.equals("Pets"));
    }
}
