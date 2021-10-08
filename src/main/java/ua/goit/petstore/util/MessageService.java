package ua.goit.petstore.util;

import com.google.gson.annotations.SerializedName;
import ua.goit.petstore.controller.handle.PetShopHandler;
import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.BaseEntity;
import ua.goit.petstore.model.Status;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.List;

public class MessageService<E extends BaseEntity<ID>, ID> {

    public void levelMessage() {
        String promptMessage = "";
        if ("Upper".equals(PetShopHandler.getConsoleLevel())) {
            promptMessage =
                    "Enter category for operation:\n" +
                            "1 - Store\n" +
                            "2 - Pet\n" +
                            "3 - User\n" +
                            "0 - Exit";
        } else if ("Store".equals(PetShopHandler.getConsoleLevel())) {
            promptMessage =
                    "\nEnter category for operation:\n" +
                            "1 - Get quantity pets by status\n" +
                            "2 - Add a new order\n" +
                            "3 - Find order by id\n" +
                            "4 - Delete order by id\n" +
                            "0 - Return to choose category";
        } else if ("Pets".equals(PetShopHandler.getConsoleLevel())) {
            promptMessage =
                    "\nEnter category for operation:\n" +
                            "1 - Add a new pet\n" +
                            "2 - Upload image for pet\n" +
                            "3 - Update pet\n" +
                            "4 - Update name and status of pet\n" +
                            "5 - Find pet by id\n" +
                            "6 - Find pets by status\n" +
                            "7 - Delete pet\n" +
                            "0 - Return to choose category";
        } else if ("User".equals(PetShopHandler.getConsoleLevel())) {
            promptMessage =
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

        }
        System.out.println(promptMessage);
    }

    public void printResult(List<String> resultData){
        resultData.forEach(System.out::println);
        System.out.println();
    }

    public void promptFormattingInput(Field field){
        EnumSet<Status> status;
        if ("Pets".equals(PetShopHandler.getConsoleLevel())){
            status = EnumSet.range(Status.AVAILABLE, Status.SOLD);
        }else{
            status = EnumSet.range(Status.PLACED, Status.DELIVERED);
        }
        String promptMessage = String.format("input %s: ",field.getAnnotation(SerializedName.class).value());
        if (field.getType().equals(Long.TYPE) || field.getName().contains("id") || field.getName().contains("Id") || "userStatus".equals(field.getName())){
            promptMessage = String.format("Input %s (only numbers): ", field.getName());
        }
        if ("phone".equals(field.getName())){
            promptMessage = String.format("Input %s in format xxx-xxx-xxxx: ", field.getName());
        }
        if ("photos".equals(field.getName())){
            promptMessage = String.format("Input path to %s with delimiter ';' (URL;URL): ", field.getName());
        }
        if ("category".equals(field.getName()) || "tags".equals(field.getName())){
            promptMessage = String.format("Input %s with delimiter ';' in format ID,NAME;ID,NAME: ", field.getName());
        }
        if (field.getName().toLowerCase().contains("date")){
            promptMessage = String.format("Input %s in format (yyyy-mm-dd): ", field.getName());
        }
        if ("isComplete".equals(field.getName())){
            promptMessage = String.format("Input %s (true/false): ", field.getName());
        }
        if ("status".equals(field.getName())){
            promptMessage = String.format("Input %s " + status +": ", field.getName());
        }
        System.out.println(promptMessage);
    }

    public void inputCorrectData(){
        System.out.println("Input correct command.\n");
    }

    public void operationEntityMgs(String operation, Class<E> modelClass, E entity){
        System.out.println("Was " + operation + " " +  modelClass.getSimpleName() + ": " + entity);
    }

    public void operationListMsg(String operation, Class<E> modelClass, List<E> listEntity){
        System.out.println("Was " + operation + " " +  modelClass.getSimpleName() + "s: " + listEntity);
    }

    public void apiResponseMsg (ApiResponse response, String mgsOk, String msgErr){
        if (response.getCode() == 200){
            sendMessage(mgsOk);
        }else{
            sendMessage(msgErr + response.getMessage());
        }
    }

    public void sendMessage (String msg){
        System.out.println(msg);
    }
}
