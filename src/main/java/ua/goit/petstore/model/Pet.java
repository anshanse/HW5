package ua.goit.petstore.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;

@Data
@Builder
public class Pet implements BaseEntity<Long>{

    @Serial
    private static final long serialVersionUID = 8036675266369240724L;

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
