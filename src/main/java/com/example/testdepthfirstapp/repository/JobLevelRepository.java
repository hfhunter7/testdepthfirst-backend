package com.example.testdepthfirstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testdepthfirstapp.domain.JobLevel;

public interface JobLevelRepository extends JpaRepository<JobLevel, Long> {

}
