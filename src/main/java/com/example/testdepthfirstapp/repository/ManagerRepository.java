package com.example.testdepthfirstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testdepthfirstapp.domain.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
