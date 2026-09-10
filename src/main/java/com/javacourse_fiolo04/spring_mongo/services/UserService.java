package com.javacourse_fiolo04.spring_mongo.services;

import com.javacourse_fiolo04.spring_mongo.domain.User;
import com.javacourse_fiolo04.spring_mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}
