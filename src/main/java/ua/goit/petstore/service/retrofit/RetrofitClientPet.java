package ua.goit.petstore.service.retrofit;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.*;
import ua.goit.petstore.model.*;
import java.util.List;

public interface RetrofitClientPet extends RetrofitClient{

    @GET("pet/findByStatus")
    @Headers("Content-Type: application/json")
    Call<List<Pet>> getByStatus(@Query("status") String status);

    @POST("pet/{petId}")
    @FormUrlEncoded
    Call<ApiResponse> updateFieldsByPetId(@Path("petId") Long id, @Field("name") String name, @Field("status") String status);

    @Multipart
    @POST("pet/{id}/uploadImage")
    Call<ApiResponse> uploadImg(@Path("id") Long id, @Part MultipartBody.Part metadata,  @Part MultipartBody.Part filePart);

    //
    @GET("pet/{entityId}")
    Call<Pet> getById(@Path("entityId") Long id);

    @POST("pet")
    Call<Pet> createEntity(@Body Pet body);

    @PUT("pet")
    Call<Pet> updateEntity(@Body Pet body);

    @DELETE("pet/{entityId}")
    Call<ApiResponse> deleteById(@Path("entityId") Long id);

}
