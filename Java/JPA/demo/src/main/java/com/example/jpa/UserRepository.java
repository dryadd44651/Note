package com.example.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

// <object, ID(key)>
public interface UserRepository extends JpaRepository<User, Long>{

}
