package ua.goit.petstore.model;


import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class User{

    @SerializedName("id")
    private Long id;

    @SerializedName("username")
    private String name;

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName")
    private String lastName;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String pass;

    @SerializedName("phone")
    private String phone;

    @SerializedName("userStatus")
    private Integer status;

}
