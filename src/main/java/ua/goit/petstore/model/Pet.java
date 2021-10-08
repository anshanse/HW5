package ua.goit.petstore.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet implements BaseEntity<Long>{

    @Serial
    private static final long serialVersionUID = 8036675266369240724L;

    @SerializedName("id")
    private Long id;

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


