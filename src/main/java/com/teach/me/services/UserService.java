package com.teach.me.services;

import com.teach.me.models.SimpleUser;
import com.teach.me.models.entities.UserEntity;
import com.teach.me.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = getFullUserByUsername(userName);
        user = new UserEntity();
        user.setUsername(userName);
        //$2a$12$6zdoF5KmZTdGH2/EkVav0.wQB.K.RxsKb6EfPeXUl0rNQ8xQaRUcS
        userRepository.findFirstByUsername(userName);
        user.setPassword(userRepository.findFirstByUsername(userName).getPassword());

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), Collections.emptyList());
    }

    public SimpleUser getUserByUsername(String userName) {
        getFullUserByUsername(userName); // user exists?
        return new SimpleUser(userName);
    }

    private UserEntity getFullUserByUsername(String userName) {
        return userRepository.findFirstByUsername(userName);
    }
}
