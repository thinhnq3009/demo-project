package com.intern.demoproject.repository;

import com.intern.demoproject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByUsername(String username);

    Optional<User> findByUsername(String username);

}