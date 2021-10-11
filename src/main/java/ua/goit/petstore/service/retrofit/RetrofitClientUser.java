package ua.goit.petstore.service.retrofit;

import retrofit2.Call;
import retrofit2.http.*;
import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.User;
import java.util.List;

public interface RetrofitClientUser {

    @POST("user/createWithList")
    Call<ApiResponse> createFromList(@Body List<User> users);

    @POST("user/createWithArray")
    Call<ApiResponse> createFromArray(@Body User[] users);

    @GET("user/{userName}")
    Call<User> getByName(@Path("userName") String userName);

    @PUT("user/{userName}")
    Call<ApiResponse> updateByName(@Path("userName") String username, @Body User user);

    @GET("user/login")
    Call<ApiResponse> login(@Query("userName") String userName, @Query("password") String pass);

    @GET("user/logout")
    Call<ApiResponse> logout();

    //
    @GET("user/{entityId}")
    Call<User> getById(@Path("entityId") Long id);

    @POST("user")
    Call<ApiResponse> createEntity(@Body User body);

    @PUT("user/{userName}")
    Call<User> updateEntity(@Path("userName") String userName,@Body User body);

    @DELETE("user/{userName}")
    Call<ApiResponse> deleteByName(@Path("userName") String userName);

}
