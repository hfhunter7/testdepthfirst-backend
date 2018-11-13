package com.example.testdepthfirstapp.repository.impl;

import com.example.testdepthfirstapp.domain.Employee;
import com.example.testdepthfirstapp.domain.PettyCash;
import com.example.testdepthfirstapp.domain.StatusPrettyCash;
import com.example.testdepthfirstapp.repository.PettyCashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PettyCashRepositoryService {

    @Autowired
    private PettyCashRepository pettyCashRepository;

    public PettyCashRepositoryService() {

    }

    public PettyCash save(PettyCash pettyCash) {
        return pettyCashRepository.save(pettyCash);
    }

    public void update(PettyCash pettyCash) {
        pettyCashRepository.save(pettyCash);
    }

    public void update(List<PettyCash> pettyCashList) {
        pettyCashRepository.save(pettyCashList);
    }

    public void delete(Long id) {
        pettyCashRepository.delete(id);
    }

    public void delete(PettyCash pettyCash) {
        pettyCashRepository.delete(pettyCash);
    }

    public PettyCash find(Long id) {
        return pettyCashRepository.findOne(id);
    }

    public List<PettyCash> findAll() {
        return pettyCashRepository.findAll();
    }

    public List<PettyCash> findByEmployee(Employee employee) {
        return pettyCashRepository.findByEmployee(employee);
    }

    public List<PettyCash> findByStatusPettyCash(StatusPrettyCash statusPrettyCash) {
        return pettyCashRepository.findByStatusPrettyCash(statusPrettyCash);
    }
}
