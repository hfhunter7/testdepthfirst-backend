package com.example.testdepthfirstapp.repository.impl;

import com.example.testdepthfirstapp.domain.Manager;
import com.example.testdepthfirstapp.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerRepositoryService {

    @Autowired
    private ManagerRepository managerRepository;

    public ManagerRepositoryService() {

    }

    public Manager save(Manager manager) {
        return managerRepository.save(manager);
    }

    public void update(Manager manager) {
        managerRepository.save(manager);
    }

    public void update(List<Manager> managerList) {
        managerRepository.save(managerList);
    }

    public void delete(Long id) {
        managerRepository.delete(id);
    }

    public void delete(Manager manager) {
        managerRepository.delete(manager);
    }

    public Manager find(Long id) {
        return managerRepository.findOne(id);
    }

    public List<Manager> findAll() {
        return managerRepository.findAll();
    }
}
