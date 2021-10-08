package ua.goit.petstore.repository;

import lombok.SneakyThrows;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.goit.petstore.config.PropertiesLoader;
import ua.goit.petstore.model.BaseEntity;
import ua.goit.petstore.service.retrofit.RetrofitClient;
import ua.goit.petstore.service.retrofit.RetrofitConfig;
import java.util.*;

public class BaseRepositoryImpl<T extends BaseEntity<ID>, ID> implements BaseRepository<T, ID> {

    private final RetrofitClient connection;
    private final Class<T> modelClass;
    private static final String BASE_URL = PropertiesLoader.getProperty("api.url");

    @SneakyThrows
    public BaseRepositoryImpl(Class<T> modelClass) {
        this.connection = RetrofitConfig.createClient(BASE_URL, GsonConverterFactory.create(), RetrofitClient.class);
        this.modelClass = modelClass;
    }

    @Override
    public T save(T t) {
        return null;
    }

    @Override
    public T deleteById(ID id) {
        return null;
    }

    @Override
    public T getOne(ID id) {
        return null;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.empty();
    }

}
