package ua.goit.petstore.repository;

import lombok.SneakyThrows;
import ua.goit.petstore.model.BaseEntity;
import ua.goit.petstore.service.retrofit.RFClient;
import ua.goit.petstore.service.retrofit.RetrofitClient;
import ua.goit.petstore.service.retrofit.RetrofitConfig;
import java.util.*;

public class BaseRepositoryImpl<T extends BaseEntity<ID>, ID> implements BaseRepository<T, ID> {

    private final RetrofitClient connection;
    private final Class<T> modelClass;

    @SneakyThrows
    public BaseRepositoryImpl(Class<T> modelClass) {
        this.connection = RFClient.getClient();
        this.modelClass = modelClass;
    }

    @SneakyThrows
    @Override
    public Optional<T> findById(ID id) {
        return Optional.of((T)RetrofitConfig.execute(connection.getById(modelClass.getName(), (Long) id)));
    }

    @Override
    public T getOne(ID id) {
        return findById(id).orElseThrow(()-> new RuntimeException("Entity with id " + id + " not found"));
    }

    @SneakyThrows
    @Override
    public T deleteById(ID id) {
        T deletingEntity = getOne(id);
        RetrofitConfig.execute(connection.deleteById(modelClass.getName(), (Long) id));
        return deletingEntity;
    }


    @SneakyThrows
    @Override
    public T save(T t) {
        if (t.getId() == null || !findById(t.getId()).isPresent()) {
            return ((T) RetrofitConfig.execute(connection.createEntity(modelClass.getName(), t)));
        }
        else {
            return ((T) RetrofitConfig.execute(connection.updateEntity(modelClass.getName(), t)));
        }
    }

}
