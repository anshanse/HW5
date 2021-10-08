package ua.goit.petstore.util;

import ua.goit.petstore.controller.handle.PetShopHandler;
import ua.goit.petstore.model.Status;

import java.lang.reflect.Field;
import java.util.EnumSet;

public class DataValidator {

    public boolean validateInputData (String inputData, Field field){
        String textMatch = "[A-Za-z0-9\\s]+";
        EnumSet<Status> status;
        if ("Pets".equals(PetShopHandler.getConsoleLevel())){
            status = EnumSet.range(Status.AVAILABLE, Status.SOLD);
        }else{
            status = EnumSet.range(Status.PLACED, Status.DELIVERED);
        }
        if (field.getType().equals(Long.TYPE) || field.getName().contains("id") || field.getName().contains("Id") ||
                "userStatus".equals(field.getName()) || "quantity".equals(field.getName())){
            textMatch = "\\d+";
        }
        if ("phone".equals(field.getName())){
            textMatch = "\\d{3}-\\d{3}-\\d{4}";
        }
        if ("photos".equals(field.getName())){
            textMatch = "\\w+(;\\w+)?";
        }
        if ("category".equals(field.getName()) || "tags".equals(field.getName())){
            textMatch = "(\\d+,\\w+)+(;\\d+,\\w+)?";
        }
        if (field.getName().toLowerCase().contains("date")){
            textMatch = "\\d{4}-\\d{2}-\\d{2}";
        }
        if ("isComplete".equals(field.getName())){
            textMatch = "(true)|(false)";
        }
        if ("status".equals(field.getName())){
            return compareEnum(status, inputData);
        }
        return inputData.matches(textMatch);
    }

    private boolean compareEnum(EnumSet<Status> set, String compareData){
        for (Status s: set){
            if (s.name().equals(compareData.toUpperCase())){
                return true;
            }
        }
        return false;
    }

    public Boolean validateStatus(String inputData) {
        EnumSet<Status> status;
        if ("Pets".equals(PetShopHandler.getConsoleLevel())) {
            status = EnumSet.range(Status.AVAILABLE, Status.SOLD);
        } else {
            status = EnumSet.range(Status.PLACED, Status.DELIVERED);
        }
        return compareEnum(status, inputData);

    }

}
