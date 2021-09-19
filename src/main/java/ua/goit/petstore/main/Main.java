package ua.goit.petstore.main;

import lombok.SneakyThrows;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.goit.petstore.config.PropertiesLoader;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.model.Status;
import ua.goit.petstore.servie.retrofit.RetrofitClient;

import java.io.File;
import java.util.List;

import static ua.goit.petstore.servie.retrofit.RetrofitConfig.createClient;
import static ua.goit.petstore.servie.retrofit.RetrofitConfig.execute;

public class Main {

    static String urlPath = PropertiesLoader.getProperty("api.url");

    @SneakyThrows
    public static void main(String[] args) {
        RetrofitClient client = createClient(urlPath, GsonConverterFactory.create(),RetrofitClient.class);
        List<Pet> availablePet = execute(client.getPetByStatus(Status.SOLD.name().toLowerCase()));
        //System.out.println(availablePet);
        Pet newPet = Pet.builder()
                .id(500)
                .name("swap")
                .build();
        Pet executePet = execute(client.createPet(newPet));
        //System.out.println(executePet);
        File file = new File("D:\\foto_13965.gif");
        MultipartBody.Part filePart = MultipartBody.Part
                .createFormData("file", file.getName(), RequestBody.create(file, MediaType.parse("image/*")));
        ResponseBody executeImg = execute(client.uploadPetImg(100, filePart));
        //System.out.println(executeImg.string());
        newPet.setName("pawn");
        Pet updatePet = execute(client.updatePet(newPet));
        //System.out.println(updatePet);
        Pet petById = execute(client.getPetsById(100));
        System.out.println(petById);
    }
}
