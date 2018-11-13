package com.example.testdepthfirstapp.repository.impl;

import com.example.testdepthfirstapp.domain.JobLevel;
import com.example.testdepthfirstapp.repository.JobLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobLevelRepositoryService {

    @Autowired
    private JobLevelRepository jobLevelRepository;

    public JobLevelRepositoryService() {

    }

    public JobLevel save(JobLevel jobLevel) {
        return jobLevelRepository.save(jobLevel);
    }

    public void update(JobLevel jobLevel) {
        jobLevelRepository.save(jobLevel);
    }

    public void update(List<JobLevel> jobLevelList) {
        jobLevelRepository.save(jobLevelList);
    }

    public void delete(Long id) {
        jobLevelRepository.delete(id);
    }

    public void delete(JobLevel jobLevel) {
        jobLevelRepository.delete(jobLevel);
    }

    public JobLevel find(Long id) {
        return jobLevelRepository.findOne(id);
    }

    public List<JobLevel> findAll() {
        return jobLevelRepository.findAll();
    }
}
