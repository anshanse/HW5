package ua.goit.petstore.controller.handle;

import ua.goit.petstore.service.PetService;
import ua.goit.petstore.service.StoreService;
import ua.goit.petstore.service.UserService;
import ua.goit.petstore.util.MessageService;
import ua.goit.petstore.util.ReadData;

public abstract class PetShopHandler {

    private final PetShopHandler handler;
    protected final PetService petService = new PetService();
    protected final StoreService storeService = new StoreService();
    protected final UserService userService = new UserService();
    protected static String consoleLevel ="Upper";
    protected final MessageService message = new MessageService();
    protected final ReadData readData = new ReadData();

    public static String getConsoleLevel() {
        return consoleLevel;
    }

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
        return new HandlerPetSection(new HandlerStoreSection(new HandlerUserSection(new HandlerPetAddNew
                (new HandlerPetUploadImg(new HandlerPetUpdate(new HandlerPetUpdateById(new HandlerPetFindById
                        (new HandlerPetFindByStatus(new HandlerPetDelete(new HandlerStorePetsByStatus
                                (new HandlerStoreNewOrder(new HandlerStoreFindOrderById(new HandlerStoreDeleteOrder
                                        (new HandlerUserCreate(new HandlerUsersFromArray(new HandlerUsersFromList
                                                (new HandlerUserUpdate(new HandlerUserGetByName(new HandlerUserLogin
                                                        (new HandlerUserLogout( new HandlerUserDelete
                                                                (new HandlerOutOfSelection(new HandlerExit())))))))))))))))))))))));
    }
}
