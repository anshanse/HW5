package ua.goit.petstore.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.annotations.SerializedName;
import lombok.SneakyThrows;
import ua.goit.petstore.model.BaseEntity;
import ua.goit.petstore.model.Status;
import ua.goit.petstore.model.Tag;
import ua.goit.petstore.util.MessageService;
import ua.goit.petstore.util.ReadData;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseService<E extends BaseEntity<ID>, ID> {

    private final ReadData readData = new ReadData();
    protected final MessageService message = new MessageService();

    public E create(Class<E> modelClass){
        Map<String,String> mapColumnField = Arrays.stream(modelClass.getDeclaredFields())
                .filter(modelField -> !Modifier.isStatic(modelField.getModifiers()))
                .collect(Collectors.toMap(modelField -> getColumn(modelField), modelField -> modelField.getName()));
        BaseEntity entity = getEntity(mapColumnField, modelClass);
        return (E) entity;
    }
    @SneakyThrows
    private BaseEntity getEntity(Map<String,String> mapColumnField, Class modelClass){
        Map<String,Object> mapEntity = new HashMap<>();
        for (Map.Entry<String,String> element : mapColumnField.entrySet()) {
            String key = element.getValue();
            String response = readData.readField(modelClass.getDeclaredField(key));
            if ("tags".equals(key)){
                int tagCount = 0;
                String[] responseArray = response.split(";");
                Tag[] tagsArray = new Tag[responseArray.length];
                for (String s : responseArray){
                    tagsArray[tagCount++] = new Tag(s);
                }
                mapEntity.put(key,tagsArray);
            }else if("status".equals(key)){
                mapEntity.put(key, Status.valueOf(response.toUpperCase()));
            }else if ("photos".equals(key)){
                String[] responseArray = response.split(";");
                mapEntity.put(key,responseArray);
            }
            else{
                mapEntity.put(key,response);
            }
        }
        ObjectMapper jacksonMapper = new ObjectMapper();
        return (BaseEntity) jacksonMapper.convertValue(mapEntity, modelClass);
    }

    private String getColumn(Field modelField) {
        return modelField.getAnnotationsByType(SerializedName.class) == null ? modelField.getName() : modelField.getAnnotation(SerializedName.class).value();
    }

}
