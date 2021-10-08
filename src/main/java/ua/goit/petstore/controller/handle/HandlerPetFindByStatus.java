package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.Pet;
import java.util.List;

public class HandlerPetFindByStatus extends PetShopHandler{

    public HandlerPetFindByStatus(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        message.sendMessage("Input Pet status");
        List<Pet> entity = petService.findByStatus(readData.readStatus());
        message.operationListMsg("find", Pet.class, entity);
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("6".equals(inputNumber) && consoleLevel.equals("Pets"));
    }
}
