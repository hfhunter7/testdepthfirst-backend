package com.example.testdepthfirstapp.repository.impl;

import com.example.testdepthfirstapp.repository.UsersRepository;
import com.example.testdepthfirstapp.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersRepositoryService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersRepositoryService() {

    }

    public Users save(Users users) {
        return usersRepository.save(users);
    }

    public void update(Users users) {
        usersRepository.save(users);
    }

    public void update(List<Users> usersList) {
        usersRepository.save(usersList);
    }

    public void delete(Long id) {
        usersRepository.delete(id);
    }

    public void delete(Users users) {
        usersRepository.delete(users);
    }

    public Users find(Long id) {
        return usersRepository.findOne(id);
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }
}
