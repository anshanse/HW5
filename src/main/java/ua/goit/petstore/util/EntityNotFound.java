package ua.goit.petstore.util;

public class EntityNotFound extends Exception{

    public EntityNotFound(Long id){
        System.out.println("Entity with id " + id + " not found");
    }
}
