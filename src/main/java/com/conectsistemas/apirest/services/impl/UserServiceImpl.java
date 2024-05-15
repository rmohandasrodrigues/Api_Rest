package com.conectsistemas.apirest.services.impl;

import com.conectsistemas.apirest.Repository.UserRepository;
import com.conectsistemas.apirest.domain.User;
import com.conectsistemas.apirest.services.UserService;
import com.conectsistemas.apirest.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }
}
