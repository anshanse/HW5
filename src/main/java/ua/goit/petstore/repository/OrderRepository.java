package ua.goit.petstore.repository;

import ua.goit.petstore.service.retrofit.RFClient;
import ua.goit.petstore.service.retrofit.RetrofitClientStore;
import ua.goit.petstore.service.retrofit.RetrofitConfig;

import java.util.Map;

public class OrderRepository extends BaseRepositoryImpl{

    private final RetrofitClientStore connection;

    public OrderRepository(Class modelClass) {
        super(modelClass);
        this.connection = (RetrofitClientStore) RFClient.getClient();
    }

    public Map<String, Integer> getOrdersByStatus(){
        return RetrofitConfig.execute(connection.getStoreInvToMap());
    }

}
