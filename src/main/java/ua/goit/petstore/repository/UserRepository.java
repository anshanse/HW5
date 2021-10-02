package ua.goit.petstore.repository;

import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.User;
import ua.goit.petstore.service.retrofit.RFClient;
import ua.goit.petstore.service.retrofit.RetrofitClientUser;
import ua.goit.petstore.service.retrofit.RetrofitConfig;

import java.util.List;

public class UserRepository extends BaseRepositoryImpl{

    private final RetrofitClientUser connection;

    public UserRepository(Class modelClass) {
        super(modelClass);
        this.connection = (RetrofitClientUser) RFClient.getClient();
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

    public ApiResponse update (String name, User user){
        return RetrofitConfig.execute(connection.updateByName(name, user));
    }

    public ApiResponse login (String name, String pass){
        return RetrofitConfig.execute(connection.login(name, pass));
    }

    public ApiResponse logout(){
        return RetrofitConfig.execute(connection.logout());
    }

}
