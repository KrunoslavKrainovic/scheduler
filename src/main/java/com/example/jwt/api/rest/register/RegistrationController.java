package com.example.jwt.api.rest.register;

import com.example.jwt.acces.database.entitiy.User;
import com.example.jwt.domain.exception.AccountAlreadyExistException;
import com.example.jwt.domain.AccountManagementService;
import com.example.jwt.domain.exception.InvalidEmailException;
import com.example.jwt.domain.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RegistrationController {

  private UserService userService;
  private AccountManagementService accountManagementService;

  public RegistrationController(UserService userService, AccountManagementService accountManagementService) {
    this.userService = userService;
    this.accountManagementService = accountManagementService;
  }

  @ResponseStatus(HttpStatus.CONFLICT)
  @ExceptionHandler(AccountAlreadyExistException.class)
  public String accountAlreadyExist() {
    return "Email in use";
  }

  @ResponseStatus(HttpStatus.CONFLICT)
  @ExceptionHandler(InvalidEmailException.class)
  public String invalidEmailException() {
    return "Invalid email";
  }


  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PostMapping("/v1/user")
  public void registration(@RequestBody RegisterRequest registerRequest) {

    User user = new User();

    user.setUsername(registerRequest.getUsername());

    user.setPassword(registerRequest.getPassword());

    accountManagementService.registerUser(user);

  }

  @GetMapping("/user/{username}")
  public User getUserByUsername(@PathVariable String username) {
    return userService.getUserByUsername(username);
  }

}
