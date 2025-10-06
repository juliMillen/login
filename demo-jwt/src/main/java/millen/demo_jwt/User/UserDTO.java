package millen.demo_jwt.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String lastName;
    private String firstName;
    private String country;
    private Role role;
}
