package ua.goit.petstore.service.retrofit;

import retrofit2.Call;
import retrofit2.http.*;
import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.Order;
import java.util.Map;

public interface RetrofitClientStore {

    @GET("store/inventory")
    Call<ApiResponse> getStoreInventory();

    @GET("store/inventory")
    Call<Map<String,Integer>> getStoreInvToMap();

    @GET("store/order/{entityId}")
    Call<Order> getById(@Path("entityId") Long id);

    @POST("store/order")
    Call<Order> createEntity(@Body Order body);

    @DELETE("store/order/{entityId}")
    Call<ApiResponse> deleteById(@Path("entityId") Long id);

}
