package com.example.testdepthfirstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testdepthfirstapp.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
