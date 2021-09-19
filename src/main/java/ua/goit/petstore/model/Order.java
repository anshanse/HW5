package ua.goit.petstore.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Order {
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
