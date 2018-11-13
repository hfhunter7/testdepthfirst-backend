package com.example.testdepthfirstapp.repository.impl;

import com.example.testdepthfirstapp.domain.StatusPrettyCash;
import com.example.testdepthfirstapp.repository.StatusPrettyCashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusPrettyCashRepositoryService {

    @Autowired
    private StatusPrettyCashRepository statusPrettyCashRepository;

    public StatusPrettyCashRepositoryService() {

    }

    public StatusPrettyCash save(StatusPrettyCash statusPrettyCash) {
        return statusPrettyCashRepository.save(statusPrettyCash);
    }

    public void update(StatusPrettyCash statusPrettyCash) {
        statusPrettyCashRepository.save(statusPrettyCash);
    }

    public void update(List<StatusPrettyCash> statusPrettyCashList) {
        statusPrettyCashRepository.save(statusPrettyCashList);
    }

    public void delete(Long id) {
        statusPrettyCashRepository.delete(id);
    }

    public void delete(StatusPrettyCash statusPrettyCash) {
        statusPrettyCashRepository.delete(statusPrettyCash);
    }

    public StatusPrettyCash find(Long id) {
        return statusPrettyCashRepository.findOne(id);
    }

    public List<StatusPrettyCash> findAll() {
        return statusPrettyCashRepository.findAll();
    }
}
