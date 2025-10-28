package millen.demo_jwt.User;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO getUser(Integer id) {
        if(id == null) {
            return null;
        }
        User user = userRepository.findById(id).orElse(null);
        if(user != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(user.getUsername());
            userDTO.setLastname(user.getLastName());
            userDTO.setFirstname(user.getFirstName());
            userDTO.setCountry(user.getCountry());
            userDTO.setRole(user.getRole());
            return userDTO;
        }
        return null;
    }

    @Transactional
    public UserDTO updateUser(UserRequest user) {
        if(user == null) {
            return null;
        }
        UserDTO nuevoDTO = new UserDTO();
        nuevoDTO.setUsername(user.getUsername());
        nuevoDTO.setLastname(user.getLastname());
        nuevoDTO.setFirstname(user.getFirstname());
        nuevoDTO.setCountry(user.getCountry());
        return nuevoDTO;
    }
}
