package ua.goit.petstore.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;

    public Tag(String param){
        String[] parameters = param.split(",");
        this.id = Long.valueOf(parameters[0]);
        this.name = parameters[1];
    }
}
