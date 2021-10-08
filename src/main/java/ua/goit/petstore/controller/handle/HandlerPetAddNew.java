package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.Pet;

public class HandlerPetAddNew extends PetShopHandler{

    public HandlerPetAddNew(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        Pet entity = petService.create(Pet.class);
        Pet savedEntity =petService.save(entity);
        message.operationEntityMgs("created", Pet.class, savedEntity);
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("1".equals(inputNumber) && consoleLevel.equals("Pets"));
    }
}
