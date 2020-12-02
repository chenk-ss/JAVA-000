package com.chenk.shardingsphere.repo;


import com.chenk.shardingsphere.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
