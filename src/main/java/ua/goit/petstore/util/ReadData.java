package ua.goit.petstore.util;

import java.lang.reflect.Field;
import java.util.Scanner;

public class ReadData {

    private final Scanner in = new Scanner(System.in);
    private final DataValidator validator = new DataValidator();
    private final MessageService message = new MessageService();

    public String readConsole(){
        return in.nextLine();
    }

    public String readField(Field field){
        String inputData = "";
        while (!validator.validateInputData(inputData, field)) {
            message.promptFormattingInput(field);
            inputData = readConsole();
        }
        return inputData;
    }

    public String readStatus(){
        String inputData = "";
        while (!validator.validateStatus(inputData)) {
            //message.promptFormattingInput();
            inputData = readConsole();
        }
        return inputData;
    }
}
