package ua.goit.petstore.controller.handle;

import okhttp3.MultipartBody;
import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.service.PetService;

import java.io.File;

public class HandlerPetUploadImg extends PetShopHandler{

    public HandlerPetUploadImg(PetShopHandler handler) {
        super(handler);
    }

    @Override
    protected void apply() {
        message.sendMessage("Input pet id:");
        Long id = Long.valueOf(readData.readConsole());
        message.sendMessage("Input path to image:");
        File file = new File(readData.readConsole());
        message.sendMessage("Input metadata to image:");
        String metadata = readData.readConsole();
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName());
        MultipartBody.Part addMetadata = MultipartBody.Part.createFormData("additionalMetadata", metadata);
        ApiResponse updImgResponse = petService.uploadImg(id, addMetadata, body);
        message.apiResponseMsg(updImgResponse, "Image added", "");
    }

    @Override
    protected boolean isApplicable(String inputNumber) {
        return ("2".equals(inputNumber) && consoleLevel.equals("Pets"));
    }
}
