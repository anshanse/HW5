package ua.goit.petstore.servie.retrofit;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;
import ua.goit.petstore.model.Pet;

import java.util.List;

public interface RetrofitClient {

    @GET("pet/findByStatus")
    @Headers("Content-Type: application/json")
    Call<List<Pet>> getPetByStatus(@Query("status") String status);

    @GET("pet/{petId}")
    @Headers("Content-Type: application/json")
    Call<Pet> getPetsById(@Path("petId") int id);

    @POST("pet")
    Call<Pet> createPet(@Body Pet newPet);

    @POST("pet/{petId}")
    Call<ResponseBody> updatePetFields(@Path("petId") int id, @Field("name") String name, @Field("status") String status);

    @Multipart
    @POST("pet/{id}/uploadImage")
    Call<ResponseBody> uploadPetImg (@Path("id") int id, @Part MultipartBody.Part filePart);

    @PUT("pet")
    Call<Pet> updatePet(@Body Pet pet);
}
