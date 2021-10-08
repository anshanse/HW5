package ua.goit.petstore.controller.handle;

import ua.goit.petstore.model.ApiResponse;

public class HandlerPetUpdateById extends PetShopHandler{

    public HandlerPetUpdateById(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        message.sendMessage("Input pet ID:");
        Long id = Long.valueOf(readData.readConsole());
        message.sendMessage("Input new pet name:");
        String name = readData.readConsole();
        message.sendMessage("Input new pet status:");
        String status = readData.readConsole();
        ApiResponse updateResponse = petService.updateFieldsByPetId(id, name, status);
        message.apiResponseMsg(updateResponse, "Pet data updated", "Pet ");
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("4".equals(inputNumber) && consoleLevel.equals("Pets"));
    }
}
