package com.wstutorial.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    private static List<User> dummyUsers = new ArrayList<>();


    public CustomUserDetailsService() {
        dummyUsers.add(new User("john","{noop}secret", "USER"));
        dummyUsers.add(new User("admin", "{noop}supersecret", "ADMIN"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = dummyUsers.stream()
                .filter(u -> u.getName().equals(username)).findAny();

        if(!user.isPresent()){
            throw new UsernameNotFoundException("User not found :" + username);
        }

        return mapUserDetails(user.get());
    }

    private UserDetails mapUserDetails(User user){
        return org.springframework.security.core.userdetails.User.withUsername(user.getName())
                .password(user.getPassword())
                .roles(user.getRole()).build();
    }
}
