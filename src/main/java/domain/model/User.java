package domain.model;

import lombok.*;

import java.util.Collections;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class User {

    @Getter
    private String username;
    @Getter
    private String password;
    @Getter
    private Set<UserRole> roles;

    // this is just an example, you can load the user from the database (via PanacheEntityBase)
    public static User findByEmail(String email) {

        //if using Panache pattern (extends or PanacheEntity PanacheEntityBase)
        //return find("username", username).firstResult();


        String userUsername = "user@gmail.com";

        //generated from password encoder
        String userPassword = "cBrlgyL2GI2GINuLUUwgojITuIufFycpLG4490dhGtY=";

        String adminUsername = "admin@gmail.com";

        //generated from password encoder
        String adminPassword = "dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=";

        if (email.equals(userUsername)) {
            return new User(userUsername, userPassword, Collections.singleton(UserRole.AUTHENTICATED_USER));
        } else if (email.equals(adminUsername)) {
            return new User(adminUsername, adminPassword, Collections.singleton(UserRole.ADMIN));
        } else {
            return null;
        }
    }

}
