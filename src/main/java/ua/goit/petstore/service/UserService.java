package ua.goit.petstore.service;

import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.User;
import ua.goit.petstore.repository.UserRepository;
import ua.goit.petstore.util.ReadData;

import java.util.ArrayList;
import java.util.List;

public class UserService extends BaseService<User, Long>{

    private final UserRepository repository = new UserRepository(User.class);
    private final ReadData readData = new ReadData();

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
        return repository.updateUser(name, user);
    }

    public ApiResponse login (String name, String pass){
        return repository.login(name, pass);
    }

    public ApiResponse logout(){
        return repository.logout();
    }
    //
    public ApiResponse save (User user){
        return repository.save(user);
    }


    public User delete(Long id){
        return repository.deleteById(id);
    }

    public List<User> readUsersToList(){
        List<User> usersList = new ArrayList<>();
        String inputData = "";
        while (!"exit".equalsIgnoreCase(inputData)){
            User newUser = create(User.class);
            usersList.add(newUser);
            message.sendMessage("Press Enter for input next user or type EXIT for stop");
            inputData = readData.readConsole();
        }
        return usersList;
    }

    public User[] listToArray (List<User> userList){
        User[] userArray = new User[userList.size()];
        int count = 0;
        for (User u: userList){
            userArray[count++] = u;
        }
        return userArray;
    }
}
