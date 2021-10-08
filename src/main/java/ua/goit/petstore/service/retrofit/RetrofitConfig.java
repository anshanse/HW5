package ua.goit.petstore.service.retrofit;

import lombok.SneakyThrows;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Converter.Factory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitConfig {
    public static  <T> T createClient(String apiUrl, Factory factory, Class<T> clientClass) {
        return new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl(apiUrl)
                .addConverterFactory(factory)
                .build()
                .create(clientClass);
    }

    @SneakyThrows
    public static <T> T execute(Call<T> call){
        Response<T> response = call.execute();
        if (!response.isSuccessful()) {
            String errorMessage = "HTTP error code: " + response.code() + " -> " + response.errorBody().string();
        }
        return response.body();
    }
}
