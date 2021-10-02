package ua.goit.petstore.repository;

import okhttp3.MultipartBody;
import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.service.retrofit.RFClient;
import ua.goit.petstore.service.retrofit.RetrofitClientPet;
import ua.goit.petstore.service.retrofit.RetrofitConfig;

import java.util.List;

public class PetRepository extends BaseRepositoryImpl{

    private final RetrofitClientPet connection;

    public PetRepository(Class modelClass) {
        super(modelClass);
        this.connection = (RetrofitClientPet) RFClient.getClient();
    }

    public ApiResponse uploadImg(Long id, MultipartBody.Part body){
        return RetrofitConfig.execute(connection.uploadImg(id, body));
    }

    public ApiResponse updateFieldsByPetId (Long id, String name, String status){
        return RetrofitConfig.execute(connection.updateFieldsByPetId(id, name, status));
    }

    public List<Pet> findByStatus(String status){
        return RetrofitConfig.execute(connection.getByStatus(status));
    }

}
