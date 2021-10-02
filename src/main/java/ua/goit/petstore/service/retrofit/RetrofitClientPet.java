package ua.goit.petstore.service.retrofit;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.*;
import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.Order;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.model.User;

import java.util.List;
import java.util.Map;

public interface RetrofitClientPet extends RetrofitClient{

    @GET("pet/findByStatus")
    @Headers("Content-Type: application/json")
    Call<List<Pet>> getByStatus(@Query("status") String status);

    @POST("pet/{petId}")
    @FormUrlEncoded
    Call<ApiResponse> updateFieldsByPetId(@Path("petId") Long id, @Field("name") String name, @Field("status") String status);

    @Multipart
    @POST("pet/{id}/uploadImage")
    Call<ApiResponse> uploadImg(@Path("id") Long id, @Part MultipartBody.Part filePart);

}
