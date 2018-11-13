package com.example.testdepthfirstapp.repository.impl;

import com.example.testdepthfirstapp.domain.Department;
import com.example.testdepthfirstapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentRepositoryService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentRepositoryService() {

    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public void update(Department department) {
        departmentRepository.save(department);
    }

    public void update(List<Department> departmentList) {
        departmentRepository.save(departmentList);
    }

    public void delete(Long id) {
        departmentRepository.delete(id);
    }

    public void delete(Department department) {
        departmentRepository.delete(department);
    }

    public Department find(Long id) {
        return departmentRepository.findOne(id);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}
