package com.example.jwt.api.rest.auth;

import com.example.jwt.domain.AccountManagementService;
import com.example.jwt.domain.exception.IncorrectPasswordException;
import com.example.jwt.domain.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AuthController {

  private AccountManagementService accountManagementService;


  public AuthController(AccountManagementService accountManagementService) {
    this.accountManagementService = accountManagementService;

  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(UserNotFoundException.class)
  public String userNotFound() {
    return "Username or password is wrong";
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(IncorrectPasswordException.class)
  public String incorrectPassword() {
    return "Username or password is wrong";
  }

  @PostMapping("/v1/authentication")
  public Token createToken(@RequestBody LoginRequest loginRequest) {

    //TODO: stavi token u login i vidi zas vracas pw

    //TODO: stavi exp na svaki exp classu

    //TODO: stavi api v1 link

    //TODO: napravi novu user classu za request i response

    //TODO: napravi response i request objekti

    return accountManagementService.login(loginRequest.getUsername(),loginRequest.getPassword());

  }




}
