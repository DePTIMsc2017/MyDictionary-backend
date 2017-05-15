package hu.unideb.inf.web.controllers;


import hu.unideb.inf.persistence.entities.UserEntity;
import hu.unideb.inf.persistence.repositories.UserRepository;
import hu.unideb.inf.security.authentication.JwtTokenUtils;
import hu.unideb.inf.web.controllers.utils.EncryptionService;
import hu.unideb.inf.web.controllers.utils.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class IndexController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptionService encryptionService;

    @PostMapping("/authenticate")
    public ResponseEntity login(@Valid @RequestBody LoginDTO login) {
        UserEntity user = userRepository.findByUsername(login.getUsername());

        if (user == null) {
            throw new IllegalArgumentException(String.format("User \"%s\" not found!", login.getUsername()));
        }

        /*if (user.isBlocked()) {
            throw new UserBlockedException(String.format("User \"%s\" is blocked!", login.getUsername()));
        }*/

        if (!encryptionService.matches(login.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("invalid password");
        }

        return ResponseEntity.ok()
                .header("Access-Control-Expose-Headers", JwtTokenUtils.JWT_TOKEN_HEADER)
                .header(JwtTokenUtils.JWT_TOKEN_HEADER, JwtTokenUtils.generateToken(user)).build();
    }

    @GetMapping("/generatepass")
    public ResponseEntity generatePass(@RequestParam String pass) {
        return ResponseEntity.ok(encryptionService.encode(pass));
    }
}
