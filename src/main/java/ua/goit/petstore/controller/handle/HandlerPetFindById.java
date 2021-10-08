package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.Pet;

public class HandlerPetFindById extends PetShopHandler{

    public HandlerPetFindById(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        message.sendMessage("Input Pet ID");
        Pet entity = petService.findById(Long.valueOf(readData.readConsole()));
        message.operationEntityMgs("find", Pet.class, entity);
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("5".equals(inputNumber) && consoleLevel.equals("Pets"));
    }
}
