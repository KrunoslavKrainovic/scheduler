package com.example.jwt.api.rest;

import com.example.jwt.acces.database.entitiy.User;
import com.example.jwt.domain.UserService;
import java.security.Principal;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {

    UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }


}
