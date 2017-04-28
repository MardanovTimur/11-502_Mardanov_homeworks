package ru.itis.inform.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 25.01.17
 * UserDetailsServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

/**
 * UserDetailsService - интерфейс, описывающий логику работы
 * с данными по безопасности
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersDao usersDao;

    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        if (usersDao.isExistToken(token)) {
            User user = usersDao.findByToken(token);
            List<GrantedAuthority> authorities = createGrantedAuthorities();

            return new UserDetailsImpl(user.getUsername(), user.getPassword(), authorities);
        } else {
            return null;
        }
    }

    public static List<GrantedAuthority> createGrantedAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
    }
}
