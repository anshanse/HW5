package ua.goit.petstore.controller.handle;

public abstract class PetShopHandler {

    private final PetShopHandler handler;

    protected String consoleLevel ="Upper";

    public PetShopHandler(PetShopHandler handler){
        this.handler = handler;
    }

    protected abstract void apply();

    protected abstract boolean isApplicable(String inputNumber);

    public final void handle (String inputNumber){
        if (isApplicable(inputNumber)) apply();
        else handler.handle(inputNumber);
    }

    public static PetShopHandler of(){
        return new HandlerPetSection(new HandlerStoreSection(new HandlerUserSection(new HandlerPetAddNew(
                new HandlerPetUploadImg(new HandlerPetUpdate(new HandlerPetUpdateById(new HandlerPetFindById(
                        new HandlerPetFindByStatus(new HandlerPetDelete(new HandlerStorePetsByStatus(
                                new HandlerStoreNewOrder(new HandlerStoreFindOrderById(new HandlerStoreDeleteOrder(
                                        new HandlerUserCreate(new HandlerUsersFromArray(new HandlerUsersFromList(
                                                new HandlerExit())))))))))))))))));
    }
}
