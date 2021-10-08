package ua.goit.petstore.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements BaseEntity<Long>{

    @Serial
    private static final long serialVersionUID = 6327904689556787198L;

    @SerializedName("id")
    private Long id;

    @SerializedName("petId")
    private Long petId;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("shipDate")
    private String date;

    @SerializedName("status")
    private Status status;

    @SerializedName("complete")
    private Boolean isComplete;

}
