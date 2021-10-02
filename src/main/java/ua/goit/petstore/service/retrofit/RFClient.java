package ua.goit.petstore.service.retrofit;

import retrofit2.converter.gson.GsonConverterFactory;
import ua.goit.petstore.config.PropertiesLoader;

public class RFClient {

    private static final RetrofitClient client;

    static {
        client = RetrofitConfig.createClient(PropertiesLoader.getProperty("api.url"), GsonConverterFactory.create(), RetrofitClient.class);
    }

    private RFClient(){
    }

    public static RetrofitClient getClient(){
        return client;
    }

}
