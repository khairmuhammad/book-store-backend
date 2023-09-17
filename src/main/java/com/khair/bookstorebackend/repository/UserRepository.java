package com.khair.bookstorebackend.repository;

import java.util.Optional;

import com.khair.bookstorebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
