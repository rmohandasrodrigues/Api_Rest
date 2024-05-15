package com.conectsistemas.apirest.services;

import com.conectsistemas.apirest.domain.User;

public interface UserService {

    User findById(Integer id);
}
