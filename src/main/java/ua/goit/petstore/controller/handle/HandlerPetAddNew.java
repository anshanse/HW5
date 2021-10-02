package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.BaseEntity;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.service.PetService;
import ua.goit.petstore.util.MessageService;

public class HandlerPetAddNew extends PetShopHandler{

    private PetService service = new PetService();
    private final MessageService message = new MessageService();

    public HandlerPetAddNew(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        Pet entity = service.create(Pet.class);
        message.createEntityMgs(Pet.class, entity);
        message.petLevelMessage();
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("1".equals(inputNumber) && consoleLevel.equals("Pets"));
    }
}
