package ua.goit.petstore.service.retrofit;

import retrofit2.Call;
import retrofit2.http.*;
import ua.goit.petstore.model.ApiResponse;
import java.util.Map;

public interface RetrofitClientStore {

    @GET("store/inventory")
    Call<ApiResponse> getStoreInventory();

    @GET("store/inventory")
    Call<Map<String,Integer>> getStoreInvToMap();

}
