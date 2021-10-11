package ua.goit.petstore.repository;

import lombok.SneakyThrows;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.goit.petstore.config.PropertiesLoader;
import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.User;
import ua.goit.petstore.service.retrofit.RetrofitClientUser;
import ua.goit.petstore.service.retrofit.RetrofitConfig;

import java.util.List;
import java.util.Optional;

public class UserRepository extends BaseRepositoryImpl{

    private static final String BASE_URL = PropertiesLoader.getProperty("api.url");
    private final RetrofitClientUser connection =
            RetrofitConfig.createClient(BASE_URL, GsonConverterFactory.create(), RetrofitClientUser.class);

    public UserRepository(Class modelClass) {
        super(modelClass);
    }

    public ApiResponse createFromArray(User[] users){
        return RetrofitConfig.execute(connection.createFromArray(users));
    }

    public ApiResponse createFromList(List<User> users) {
        return RetrofitConfig.execute(connection.createFromList(users));
    }

    public User getByName(String name) {
        return RetrofitConfig.execute(connection.getByName(name));
    }

    public ApiResponse updateUser (String name, User user){
        return RetrofitConfig.execute(connection.updateByName(name, user));
    }

    public ApiResponse login (String name, String pass){
        return RetrofitConfig.execute(connection.login(name, pass));
    }

    public ApiResponse logout(){
        return RetrofitConfig.execute(connection.logout());
    }


    @SneakyThrows
    public Optional<User> findById(Long id) {
        User execute = RetrofitConfig.execute(connection.getById(id));
        if (execute == null) return Optional.empty();
        return Optional.of(execute);
    }

    public User getOne(Long id) {
        return findById(id).orElseThrow(()-> new RuntimeException("Entity with id " + id + " not found"));
    }

    @SneakyThrows
    public User deleteById(String userName) {
        User deletingEntity = getByName(userName);
        RetrofitConfig.execute(connection.deleteByName(userName));
        return deletingEntity;
    }

    public User update(String name, User u){
        return RetrofitConfig.execute(connection.updateEntity(name, u));
    }

    @SneakyThrows
    public ApiResponse save(User t) {
            return RetrofitConfig.execute(connection.createEntity(t));
    }

}
