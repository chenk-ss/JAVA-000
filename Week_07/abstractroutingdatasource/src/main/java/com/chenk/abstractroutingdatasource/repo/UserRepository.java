package com.chenk.abstractroutingdatasource.repo;


import com.chenk.abstractroutingdatasource.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
