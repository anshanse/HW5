package ua.goit.petstore.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("type")
    private String type;

    @SerializedName("message")
    private String message;
}
