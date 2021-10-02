package ua.goit.petstore.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;

@Builder
@Data
public class Order implements BaseEntity<Long>{

    @Serial
    private static final long serialVersionUID = 6327904689556787198L;

    @SerializedName("id")
    private long id;

    @SerializedName("petId")
    private long petId;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("shipDate")
    private String date;

    @SerializedName("status")
    private Status status;

    @SerializedName("complete")
    private boolean isComplete;

}
