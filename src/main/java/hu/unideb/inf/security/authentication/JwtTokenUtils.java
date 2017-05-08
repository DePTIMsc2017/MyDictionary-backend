package hu.unideb.inf.security.authentication;

import hu.unideb.inf.persistence.entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class JwtTokenUtils {
    public static final String JWT_TOKEN_HEADER = "X-AUTH-TOKEN";
    private static final String JWT_TOKEN_HEADER_PARAM = "Authorization";
    private static final String JWT_TOKEN_HEADER_PREFIX = "Bearer ";
    private static final String secret = KeyGenerators.string().generateKey();

    static String extractToken(HttpServletRequest request) {
        String header = request.getHeader(JWT_TOKEN_HEADER_PARAM);

        if (StringUtils.isEmpty(header) || !header.startsWith(JWT_TOKEN_HEADER_PREFIX)) {
            throw new JwtTokenMissingException("No JWT token!");
        }

        return header.substring(JWT_TOKEN_HEADER_PREFIX.length());
    }

    public static String generateToken(UserEntity u) {
        Claims claims = Jwts.claims().setSubject(u.getUsername());
        claims.put("id", u.getId());
        claims.put("roles", u.getRoles().stream()
                .map(item -> item.toString())
                .collect(Collectors.joining(",")));

        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    static Optional<JwtUserDto> parseToken(String token) {
        JwtUserDto user = null;

        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            user = new JwtUserDto();
            user.setUsername(body.getSubject());
            user.setId((Integer)body.get("id"));
            user.setRoles((String) body.get("roles"));
        } catch (JwtException ignored) {
        }

        return Optional.ofNullable(user);
    }
}