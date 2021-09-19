package ua.goit.petstore.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tag {

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;
}