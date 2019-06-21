package com.kk.SpringBootBackendServices.repository;

import com.kk.SpringBootBackendServices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}