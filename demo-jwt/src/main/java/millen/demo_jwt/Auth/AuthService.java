package millen.demo_jwt.Auth;

import lombok.RequiredArgsConstructor;
import millen.demo_jwt.Jwt.JwtService;
import millen.demo_jwt.User.Role;
import millen.demo_jwt.User.User;
import millen.demo_jwt.User.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    public AuthResponse login(LoginRequest loginRequest) {
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        User user = User.builder()
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .firstname(registerRequest.getFirstName())
                .lastname(registerRequest.getLastName())
                .country(registerRequest.getCountry())
                .role(Role.USER)
                .build();
        userRepository.save(user);


        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
