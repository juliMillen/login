package millen.demo_jwt.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {

        UserDTO usuario = userService.getUser(id);
        if(usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }


    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserRequest user) {
       return ResponseEntity.ok(userService.updateUser(user));
    }
}
