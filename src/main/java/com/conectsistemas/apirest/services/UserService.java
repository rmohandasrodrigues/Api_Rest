package com.conectsistemas.apirest.services;

import com.conectsistemas.apirest.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
}
