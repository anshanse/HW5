package ua.goit.petstore.service.retrofit;

import retrofit2.Call;
import retrofit2.http.*;
import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.BaseEntity;

public interface RetrofitClient {

    @GET("{entity}/{entityId}")
    Call<BaseEntity> getById(@Path("entity") String entity, @Path("entityId") Long id);

    @POST("{entity}")
    @Headers("Accept:application/json")
    Call<BaseEntity> createEntity(@Path("entity") String entity, @Body BaseEntity body);

    @PUT("{entity}")
    Call<BaseEntity> updateEntity(@Path("entity") String entity, @Body BaseEntity body);

    @DELETE("{entity}/{entityId}")
    Call<ApiResponse> deleteById(@Path("entity") String entity, @Path("entityId") Long id);

}
