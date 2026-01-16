package com.spirngboot.spirngboot.usermanagement.repository;

import com.spirngboot.spirngboot.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
