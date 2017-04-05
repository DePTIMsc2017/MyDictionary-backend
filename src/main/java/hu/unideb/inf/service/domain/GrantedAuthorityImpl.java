package hu.unideb.inf.service.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by mates on 2017. 04. 02..
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;
    public GrantedAuthorityImpl(String name) {
        authority=name;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
