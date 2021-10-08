package ua.goit.petstore.controller.handle;

import java.util.Map;

public class HandlerStorePetsByStatus extends PetShopHandler{

    public HandlerStorePetsByStatus(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        Map<String, Integer> responseByStatus = storeService.getByStatus();
        responseByStatus.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("1".equals(inputNumber) && consoleLevel.equals("Store"));
    }
}
