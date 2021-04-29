package com.example.jwt.domain;

import com.example.jwt.acces.database.entitiy.Role;
import com.example.jwt.acces.database.entitiy.User;
import com.example.jwt.acces.database.repository.RoleRepository;
import com.example.jwt.api.rest.auth.Token;
import com.example.jwt.domain.exception.IncorrectPasswordException;
import com.example.jwt.domain.exception.InvalidEmailException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountManagementServiceImpl implements AccountManagementService {

  private final Pattern VALID_EMAIL_ADDRESS_REGEX =
      Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

  private PasswordEncoder passwordEncoder;

  private UserService userService;

  private RoleRepository roleRepository;

  private JwtTokenGenerator jwtTokenGenerator;

  public AccountManagementServiceImpl(PasswordEncoder passwordEncoder,
      UserService userService, RoleRepository roleRepository,
      JwtTokenGenerator jwtTokenGenerator) {
    this.passwordEncoder = passwordEncoder;
    this.userService = userService;
    this.roleRepository = roleRepository;
    this.jwtTokenGenerator = jwtTokenGenerator;
  }

  @Override
  public Token login(String username,String password) {
    User userFromDB = userService.getUserByUsername(username);


    if (!passwordEncoder.matches(password,userFromDB.getPassword())) {
      throw new IncorrectPasswordException();
    }

    Token token = new Token();

    token.setToken(jwtTokenGenerator.createToken(username, "ROLE_USER"));

    return token;

  }

  @Override
  public void registerUser(User user) {

    validateEmail(user.getUsername());

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    Role role = roleRepository.findByName("user");

    user.setRole(role);

    userService.createUser(user);

  }


  private void validateEmail(String emailStr) {
    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);

    if(!matcher.find()){
      throw new InvalidEmailException();
    }

  }


}
