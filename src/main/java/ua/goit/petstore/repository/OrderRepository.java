package ua.goit.petstore.repository;

import lombok.SneakyThrows;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.goit.petstore.config.PropertiesLoader;
import ua.goit.petstore.model.Order;
import ua.goit.petstore.service.retrofit.RetrofitClientStore;
import ua.goit.petstore.service.retrofit.RetrofitConfig;
import ua.goit.petstore.util.EntityNotFound;

import java.util.Map;
import java.util.Optional;

public class OrderRepository extends BaseRepositoryImpl{

    private static final String BASE_URL = PropertiesLoader.getProperty("api.url");
    private final RetrofitClientStore connection =
            RetrofitConfig.createClient(BASE_URL, GsonConverterFactory.create(), RetrofitClientStore.class);

    public OrderRepository(Class modelClass) {
        super(modelClass);
    }

    public Map<String, Integer> getOrdersByStatus(){
        return RetrofitConfig.execute(connection.getStoreInvToMap());
    }

    @SneakyThrows
    public Optional<Order> findById(Long id) {
        Order execute = RetrofitConfig.execute(connection.getById(id));
        if (execute == null) return Optional.empty();
        return Optional.of(execute);
    }

    @SneakyThrows
    public Order getOne(Long id) {
        return findById(id).orElseThrow(()-> new EntityNotFound(id));
    }

    @SneakyThrows
    public Order deleteById(Long id) {
        Order deletingEntity = getOne(id);
        RetrofitConfig.execute(connection.deleteById(id));
        return deletingEntity;
    }


    @SneakyThrows
    public Order create(Order t) {
            return RetrofitConfig.execute(connection.createEntity(t));
    }

}
