package ru.itis.inform.security.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import ru.itis.inform.security.details.UserDetailsServiceImpl;

import java.util.Collection;

/**
 * 25.01.17
 * TokenAuthentication
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TokenAuthentication extends AbstractAuthenticationToken {
    private final String token;

    public TokenAuthentication(String token) {
        super(UserDetailsServiceImpl.createGrantedAuthorities());
        this.token = token;
    }

    public TokenAuthentication(Collection<? extends GrantedAuthority> authorities, String token) {
        super(authorities);
        this.token = token;
    }

    public Object getCredentials() {
        return this.getAuthorities();
    }

    public Object getPrincipal() {
        return token;
    }
}
