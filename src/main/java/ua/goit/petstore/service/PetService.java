package ua.goit.petstore.service;

import okhttp3.MultipartBody;
import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.repository.PetRepository;

import java.util.List;

public class PetService extends BaseService<Pet,Long>{

    private final PetRepository repository = new PetRepository(Pet.class);

    public ApiResponse uploadImg(Long id, MultipartBody.Part metadata, MultipartBody.Part body){
        return repository.uploadImg(id, metadata, body);
    }

    public ApiResponse updateFieldsByPetId (Long id, String name, String status){
        return repository.updateFieldsByPetId(id, name, status);
    }

    public List<Pet> findByStatus(String status){
        return repository.findByStatus(status);
    }

    public Pet save (Pet pet){
        return repository.save(pet);
    }

    public Pet update (Pet pet){
        return repository.save(pet);
    }

    public Pet delete(Long id){
        return repository.deleteById(id);
    }

    public Pet findById (Long id){
        return repository.getOne(id);
    }
}
