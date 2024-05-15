package com.conectsistemas.apirest.config;

import com.conectsistemas.apirest.Repository.UserRepository;
import com.conectsistemas.apirest.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    @Profile("local")
    public List<User> startDB() {
        User u1 = new User(null, "Raphael Mohandas", "raphaelmohandas@gmail.com", "123");
        User u2 = new User(null, "Mikaelly Borges", "mika@gmail.com", "123");

        return userRepository.saveAll(List.of(u1, u2));
    }
}
