package com.example.LoginForm.Loginrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LoginForm.Logindomain.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{

	Login findByUsernameAndPassword(String username, String password);
}
