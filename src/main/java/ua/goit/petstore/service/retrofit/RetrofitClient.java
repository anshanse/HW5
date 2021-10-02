package ua.goit.petstore.service.retrofit;

import retrofit2.Call;
import retrofit2.http.*;
import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.BaseEntity;
import ua.goit.petstore.model.Pet;

public interface RetrofitClient<T extends BaseEntity<ID>, ID> {

    @GET("{entity}/{entityId}")
    @Headers("Content-Type: application/json")
    Call<Pet> getById(@Path("entity") String entity, @Path("entityId") Long id);

    @POST("{entity}")
    Call<T> createEntity(@Path("entity") String entity, @Body T t);

    @PUT("{entity}")
    Call<T> updateEntity(@Path("entity") String entity, @Body T t);

    @DELETE("{entity}/{entityId}")
    Call<ApiResponse> deleteById(@Path("entity") String entity, @Path("entityId") Long id);

}
