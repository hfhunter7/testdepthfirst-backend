package com.example.testdepthfirstapp.repository.impl;

import com.example.testdepthfirstapp.domain.StatusEmployee;
import com.example.testdepthfirstapp.repository.StatusEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusEmployeeRepositoryService {

    @Autowired
    private StatusEmployeeRepository statusEmployeeRepository;

    public StatusEmployeeRepositoryService() {

    }

    public StatusEmployee save(StatusEmployee statusEmployee) {
        return statusEmployeeRepository.save(statusEmployee);
    }

    public void update(StatusEmployee statusEmployee) {
        statusEmployeeRepository.save(statusEmployee);
    }

    public void update(List<StatusEmployee> statusEmployeeList) {
        statusEmployeeRepository.save(statusEmployeeList);
    }

    public void delete(Long id) {
        statusEmployeeRepository.delete(id);
    }

    public void delete(StatusEmployee statusEmployee) {
        statusEmployeeRepository.delete(statusEmployee);
    }

    public StatusEmployee find(Long id) {
        return statusEmployeeRepository.findOne(id);
    }

    public List<StatusEmployee> findAll() {
        return statusEmployeeRepository.findAll();
    }
}
