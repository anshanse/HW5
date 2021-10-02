package ua.goit.petstore.util;

import ua.goit.petstore.model.BaseEntity;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

public class MessageService<E extends BaseEntity<ID>, ID> {

    public void upperLevelMessage(){
        String upperPromptMessage =
                "Enter category for operation:\n" +
                        "1 - Store\n" +
                        "2 - Pet\n" +
                        "3 - User\n" +
                        "0 - Exit";
        System.out.println(upperPromptMessage);
    }

    public void storeLevelMessage(){
        String storePromptMessage =
                "\nEnter category for operation:\n" +
                        "1 - Get quantity pets by status\n" +
                        "2 - Add a new order\n" +
                        "3 - Find order by id\n" +
                        "4 - Delete order by id\n" +
                        "0 - Return to choose category";
        System.out.println(storePromptMessage);
    }

    public void petLevelMessage(){
        String storePromptMessage =
                "\nEnter category for operation:\n" +
                        "1 - Add a new pet\n" +
                        "2 - Upload image for pet\n" +
                        "3 - Update pet\n" +
                        "4 - Update name and status of pet\n" +
                        "5 - Find pet by id\n" +
                        "6 - Find pets by status\n" +
                        "7 - Delete pet\n" +
                        "0 - Return to choose category";
        System.out.println(storePromptMessage);
    }

    public void userLevelMessage(){
        String storePromptMessage =
                "\nEnter category for operation:\n" +
                        "1 - Create a new user\n" +
                        "2 - Create new users from Array of users\n" +
                        "3 - Create new users from List of users\n" +
                        "4 - Update user by name\n" +
                        "5 - Get user by name\n" +
                        "6 - Login user\n" +
                        "7 - Logout\n" +
                        "8 - Delete user\n" +
                        "0 - Return to choose category";
        System.out.println(storePromptMessage);
    }

    public void printResult(List<String> resultData){
        resultData.forEach(System.out::println);
        System.out.println();
    }

    public void promptFormattingInput(Field field){
        String promptMessage = String.format("input %s : ",field.getName());
        if (field.getType().equals(Integer.TYPE) || field.getName().contains("id") || field.getName().contains("Id")){
            promptMessage =String.format("Input %s (only numbers): ", field.getName());
        }
        if (field.getType().equals(Date.class)){
            promptMessage = String.format("Input %s in format (yyyy-mm-dd): ", field.getName());
        }
        if ("sex".equals(field.getName())){
            promptMessage = String.format("Input %s (m/f): ", field.getName());
        }
        System.out.println(promptMessage);
    }

    public void inputCorrectData(){
        System.out.println("Input correct command.\n");
    }

    public void createEntityMgs (Class<E> modelClass, BaseEntity entity){
        System.out.println("Was create " + modelClass.getName() + ": " + entity);
    }
}
