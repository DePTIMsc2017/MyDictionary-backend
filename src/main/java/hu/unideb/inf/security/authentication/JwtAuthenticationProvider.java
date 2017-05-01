package hu.unideb.inf.security.authentication;

import hu.unideb.inf.persistence.entities.UserEntity;
import hu.unideb.inf.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    private UserRepository userRepository;

    public JwtAuthenticationProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void additionalAuthenticationChecks(
            UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {

        String token = ((JwtAuthenticationToken) authentication).getToken();

        JwtUserDto parsedUser =
                JwtTokenUtils.parseToken(token).orElseThrow(
                        () -> new JwtTokenMalformedException("token malformed!"));

        UserEntity user = userRepository.findByUsername(parsedUser.getUsername());

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User \"%s\" not found!", parsedUser.getUsername()));
        }

        /*if (user.isBlocked()) {
            throw new UserBlockedException(String.format("User \"%s\" is blocked!", parsedUser.getUsername()));
        }

        if (user.isChanged()) {
            throw new UserChangedException();
        }*/

        return new AuthenticatedUser(
                user,
                parsedUser.getUsername(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(parsedUser.getRoles()));
    }

}

