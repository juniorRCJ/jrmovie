package com.juniorcaldeira.jrmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juniorcaldeira.jrmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
}
