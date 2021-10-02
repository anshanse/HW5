package ua.goit.petstore.service;

import okhttp3.MultipartBody;
import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.repository.PetRepository;

import java.util.List;

public class PetService extends BaseService<Pet,Long>{

    private final PetRepository repository = new PetRepository(Pet.class);

    private ApiResponse uploadImg(Long id, MultipartBody.Part body){
        return repository.uploadImg(id, body);
    }

    private ApiResponse updateFieldsByPetId (Long id, String name, String status){
        return repository.updateFieldsByPetId(id, name, status);
    }

    private List<Pet> findByStatus(String status){
        return repository.findByStatus(status);
    }

}
