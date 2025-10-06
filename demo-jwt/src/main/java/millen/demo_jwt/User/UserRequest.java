package millen.demo_jwt.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Integer id;
    private String username;
    private String lastName;
    private String firstName;
    private String country;
}
