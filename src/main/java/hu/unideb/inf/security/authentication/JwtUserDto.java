package hu.unideb.inf.security.authentication;

import hu.unideb.inf.persistence.entities.UserEntity;

import java.util.stream.Collectors;

public class JwtUserDto {
    private long id;
    private String username;
    private String roles;

    public static JwtUserDto fromUser(UserEntity user) {
        JwtUserDto u = new JwtUserDto();
        u.setId(user.getId());
        u.setUsername(u.getUsername());
        u.setRoles(user.getRoles().stream()
                .map(item -> item.toString())
                .collect(Collectors.joining(",")));

        return u;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
