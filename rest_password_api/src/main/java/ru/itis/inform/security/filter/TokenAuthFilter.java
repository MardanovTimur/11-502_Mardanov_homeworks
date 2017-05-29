package ru.itis.inform.security.filter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.inform.security.auth.TokenAuthentication;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 25.01.17
 * TokenAuthFilter
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TokenAuthFilter extends GenericFilterBean {
    private static final String header = "Auth-Token";

    private AuthenticationManager authenticationManager;

    /**
     * @Autowired private AuthenticationEntryPoint authenticationEntryPoint;
     **/

    public TokenAuthFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println(httpServletRequest.getRequestURI());
        try {
            String headerValue = httpServletRequest.getHeader(header);

            if (isNotRequiringProtection(httpServletRequest)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else if (headerValue == null || headerValue.equals("")) {
                throw new IllegalArgumentException("Token not found");
            } else {
                authenticationManager.authenticate(new TokenAuthentication(headerValue));
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } catch (AuthenticationException authenticationException) {
            throw new IllegalArgumentException(authenticationException);
        }
    }

    private boolean isNotRequiringProtection(HttpServletRequest request) {
        System.out.println(request.getRequestURI());
        System.out.println(request.getMethod());
        System.out.println(request.getHeader("Auth-Token"));
        return request.getRequestURI().startsWith("/users") && request.getMethod().equals("POST")
                || request.getRequestURI().endsWith("favicon.ico")
                || request.getRequestURI().startsWith("/users/login") && request.getMethod().equals("POST");
    }
}
