package com.sbnz.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbnz.project.model.User;

public interface UserRepository extends JpaRepository<User, Long>  {

	public User findByUsername(String username);
}
