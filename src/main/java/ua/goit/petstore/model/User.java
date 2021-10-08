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
public class User implements BaseEntity<Long>{

    @Serial
    private static final long serialVersionUID = 3011172838572288595L;

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
    private Integer userStatus;

}
