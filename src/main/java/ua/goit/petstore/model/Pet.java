package ua.goit.petstore.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pet {
    @SerializedName("id")
    private long id;

    @SerializedName("category")
    private Category category;

    @SerializedName("name")
    private String name;

    @SerializedName("photoUrls")
    private String[] photos;

    @SerializedName("tags")
    private Tag[] tags;

    @SerializedName("status")
    private Status status;

}
