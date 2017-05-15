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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrantedAuthorityImpl that = (GrantedAuthorityImpl) o;

        return authority != null ? authority.equals(that.authority) : that.authority == null;
    }

    @Override
    public int hashCode() {
        return authority != null ? authority.hashCode() : 0;
    }
}
