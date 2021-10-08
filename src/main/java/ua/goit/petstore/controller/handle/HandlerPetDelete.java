package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.Pet;

public class HandlerPetDelete extends PetShopHandler{

    public HandlerPetDelete(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        message.sendMessage("Input pet ID: ");
        Pet entity = petService.delete(Long.valueOf(readData.readConsole()));
        message.operationEntityMgs("deleted", Pet.class, entity);
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("7".equals(inputNumber) && consoleLevel.equals("Pets"));
    }
}
