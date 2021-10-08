package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.Pet;

public class HandlerPetUpdate extends PetShopHandler{

    public HandlerPetUpdate(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        Pet entity = petService.create(Pet.class);
        Pet savedEntity =petService.save(entity);
        message.operationEntityMgs("updated", Pet.class, savedEntity);
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("3".equals(inputNumber) && consoleLevel.equals("Pets"));
    }
}
