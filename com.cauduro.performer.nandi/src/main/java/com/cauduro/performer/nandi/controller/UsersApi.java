package com.cauduro.performer.nandi.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cauduro.performer.nandi.models.UserModel;
import com.cauduro.performer.nandi.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/users")
public class UsersApi {

  private final UserService userService;

  public UsersApi(UserService userService) {
    this.userService = userService;
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping(value = "fetchAllUsers")
  public ResponseEntity<List<UserModel>> fetchAllUsers() {
    List<UserModel> serviceResponse = userService.fetchAllUsers();
    return ResponseEntity.ok(serviceResponse);
  }

  @GetMapping(value = "getUser/{userId}")
  public ResponseEntity<UserModel> getUser(@PathVariable("userId") UUID userId) {
    UserModel serviceResponse = userService.getUser(userId);
    return ResponseEntity.ok(serviceResponse);
  }

  @PostMapping(value = "insertUser")
  public ResponseEntity<UserModel> insertUser(@RequestBody UserModel model) {
    UserModel serviceResponse = userService.inserNewUser(model);
    return ResponseEntity.ok(serviceResponse);
  }

  @PutMapping(value = "updateUser")
  public ResponseEntity<UserModel> updateUser(@RequestBody UserModel model) {
    UserModel serviceResponse = userService.updateUser(model);
    return ResponseEntity.ok(serviceResponse);
  }

  @DeleteMapping(value = "deleteUser/{userId}")
  public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") UUID userId) {
    Boolean serviceResponse = userService.deleteUser(userId);
    return ResponseEntity.ok(serviceResponse);
  }
}
