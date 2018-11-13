package com.example.testdepthfirstapp.service;

import com.example.testdepthfirstapp.bean.CreateUserBean;
import com.example.testdepthfirstapp.exception.DataFormatException;
import com.example.testdepthfirstapp.repository.impl.UsersRepositoryService;
import com.example.testdepthfirstapp.domain.Users;
import com.example.testdepthfirstapp.service.json.UserJson;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService extends UserJson {

    @Autowired
    private UsersRepositoryService usersRepositoryService;

    @Transactional
    public ObjectNode createUser(CreateUserBean body) {
        Users user = new Users();
        user.setUsername(body.getUsername());
        user.setPassword(body.getPassword());

        try {
            user = usersRepositoryService.save(user);
            return createUserJson(user);
        } catch (DataFormatException e) {
            throw new DataFormatException("create user fail.");
        }
    }
}
