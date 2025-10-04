package odyssee_des.saveurs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import odyssee_des.saveurs.dto.LoginRequest;
import odyssee_des.saveurs.dto.LoginResponse;
import odyssee_des.saveurs.dto.RegisterRequest;
import odyssee_des.saveurs.security.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200") // pour Angular
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        String token = authService.register(request);
        return ResponseEntity.ok(token); // Retourne un JWT après inscription
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}
