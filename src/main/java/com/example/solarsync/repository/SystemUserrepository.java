package com.example.solarsync.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.solarsync.entity.SystemUser;
@Repository
public interface SystemUserrepository extends JpaRepository<SystemUser,Long>{
     Optional<SystemUser> findByEmail(String Email);
}
