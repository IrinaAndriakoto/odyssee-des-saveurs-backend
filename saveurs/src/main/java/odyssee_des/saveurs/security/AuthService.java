package odyssee_des.saveurs.security;

import odyssee_des.saveurs.dto.LoginRequest;
import odyssee_des.saveurs.dto.LoginResponse;
import odyssee_des.saveurs.dto.RegisterRequest;
import odyssee_des.saveurs.dto.UserDTO;
import odyssee_des.saveurs.model.sql.User;
import odyssee_des.saveurs.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil; // <-- changed

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }
    
    // in register and login use jwtUtil.generateToken(user.getUsername())
    public String register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("⚠️ Nom d'utilisateur déjà pris");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // ⚡ encodage obligatoire

        userRepository.save(user);
        return jwtUtil.generateToken(user.getUsername());
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new LoginResponse(token, new UserDTO(user));
    }
}
