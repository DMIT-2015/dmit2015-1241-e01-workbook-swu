package dmit2015.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * The structure of data stored FirebaseRTDB
 */
@Data
public class Student {

    private String name;    // Firebase Unique Identifier

    @NotBlank(message = "First Name value is required.")
    private String firstName;   // Student first name

    @NotBlank(message = "Last Name value is required.")
    @Size(min = 2, max = 15, message = "Last Name must contain between {min} and {max} characters" )
    private String lastName;    // Student last name

    @Email(message = "Email value is not a valid email format")
    private String email;       // Student email

}
