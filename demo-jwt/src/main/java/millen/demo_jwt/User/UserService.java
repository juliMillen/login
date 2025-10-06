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
            userDTO.setLastName(user.getLastname());
            userDTO.setFirstName(user.getFirstname());
            userDTO.setCountry(user.getCountry());
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
        nuevoDTO.setLastName(user.getLastName());
        nuevoDTO.setFirstName(user.getFirstName());
        nuevoDTO.setCountry(user.getCountry());
        return nuevoDTO;
    }
}
