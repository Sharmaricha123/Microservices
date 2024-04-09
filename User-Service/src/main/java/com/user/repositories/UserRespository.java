package com.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entities.User;

public interface UserRespository extends JpaRepository<User, String>{

}
