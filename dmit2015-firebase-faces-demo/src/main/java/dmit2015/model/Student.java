package dmit2015.model;

import lombok.Data;

/**
 * The structure of data stored FirebaseRTDB
 */
@Data
public class Student {

    private String name;    // Firebase Unique Identifier
    private String firstName;   // Student first name
    private String lastName;    // Student last name
    private String email;       // Student email

}
