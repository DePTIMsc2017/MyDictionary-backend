package hu.unideb.inf.web.controllers.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.keygen.StringKeyGenerator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {
    private static final StringKeyGenerator generator = KeyGenerators.string();

    @Autowired
    private PasswordEncoder encoder;

    public String encode(CharSequence raw) {
        return encoder.encode(raw);
    }

    public boolean matches(CharSequence raw, String encoded) {
        return encoder.matches(raw, encoded);
    }

    public String generate() {
        return generator.generateKey();
    }

    public String generateToken() {
        return encode(generate());
    }
}
