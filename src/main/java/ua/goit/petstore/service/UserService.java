package ua.goit.petstore.service;

import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.User;
import ua.goit.petstore.repository.UserRepository;

import java.util.List;

public class UserService extends BaseService<User, Long>{

    private UserRepository repository = new UserRepository(User.class);

    public ApiResponse createFromList(List<User> users){
        return repository.createFromList(users);
    }

    public ApiResponse createFromArray(User[] users){
        return repository.createFromArray(users);
    }

    public User getByName (String name){
        return repository.getByName(name);
    }

    public ApiResponse update (String name, User user){
        return repository.update(name, user);
    }

    public ApiResponse login (String name, String pass){
        return repository.login(name, pass);
    }

    public ApiResponse logout(){
        return repository.logout();
    }


}
