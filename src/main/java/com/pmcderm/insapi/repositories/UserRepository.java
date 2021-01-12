package com.pmcderm.insapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmcderm.insapi.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUserName(String userName);
}
