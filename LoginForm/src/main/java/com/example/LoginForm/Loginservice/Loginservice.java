package com.example.LoginForm.Loginservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LoginForm.Logindomain.Login;
import com.example.LoginForm.Loginrepository.LoginRepository;

@Service
public class Loginservice {

	@Autowired
    private LoginRepository repo;
  
  public Login login(String username, String password) {
      Login user = repo.findByUsernameAndPassword(username, password);
      return user;
  }
}
