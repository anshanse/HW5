package ua.goit.petstore.repository;

import lombok.SneakyThrows;
import okhttp3.MultipartBody;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.goit.petstore.config.PropertiesLoader;
import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.service.retrofit.RetrofitClientPet;
import ua.goit.petstore.service.retrofit.RetrofitConfig;

import java.util.List;
import java.util.Optional;

public class PetRepository extends BaseRepositoryImpl<Pet, Long>{

    private static final String BASE_URL = PropertiesLoader.getProperty("api.url");
    private final RetrofitClientPet connection =
            RetrofitConfig.createClient(BASE_URL, GsonConverterFactory.create(), RetrofitClientPet.class);

    public PetRepository(Class modelClass) {
        super(modelClass);
    }

    public ApiResponse uploadImg(Long id,MultipartBody.Part metadata, MultipartBody.Part body){
        return RetrofitConfig.execute(connection.uploadImg(id, metadata, body));
    }

    public ApiResponse updateFieldsByPetId (Long id, String name, String status){
        return RetrofitConfig.execute(connection.updateFieldsByPetId(id, name, status));
    }

    public List<Pet> findByStatus(String status){
        return RetrofitConfig.execute(connection.getByStatus(status));
    }

    //
    @Override
    @SneakyThrows
    public Optional<Pet> findById(Long id) {
        Pet execute = RetrofitConfig.execute(connection.getById(id));
        if (execute == null) return Optional.empty();
        return Optional.of(execute);
    }

    @Override
    public Pet getOne(Long id) {
        return findById(id).orElseThrow(()-> new RuntimeException("Entity with id " + id + " not found"));
    }

    @Override
    @SneakyThrows
    public Pet deleteById(Long id) {
        Pet deletingEntity = getOne(id);
        RetrofitConfig.execute(connection.deleteById(id));
        return deletingEntity;
    }

    @Override
    @SneakyThrows
    public Pet save(Pet t) {
        if (t.getId() == null || !findById(t.getId()).isPresent()) {
            return RetrofitConfig.execute(connection.createEntity(t));
        }
        else {
            return RetrofitConfig.execute(connection.updateEntity(t));
        }
    }

}
