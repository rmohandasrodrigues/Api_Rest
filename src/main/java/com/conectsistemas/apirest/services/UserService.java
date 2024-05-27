package com.conectsistemas.apirest.services;

import com.conectsistemas.apirest.domain.User;
import com.conectsistemas.apirest.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);
}
