package com.example.jwt.domain;

import com.example.jwt.acces.database.entitiy.User;
import com.example.jwt.api.rest.auth.Token;

public interface AccountManagementService {

  Token login(String username,String password);

  void registerUser(User user);

}
