package com.intern.demoproject.repository;

import com.intern.demoproject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByUsername(String username);

    @Query("select u from User u where u.username = ?1")
    Optional<User> findByUsername(String username);

    @Modifying
    @Query("update User u set u.avatar = ?2 where u.id = ?1")
    void updateImagePath(Long id, String newPath);
}