package com.cauduro.performer.nandi.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
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

  @GetMapping(value = "fetchAllUsers")
  public ResponseEntity<List<UserModel>> fetchAllUsers() {
    List<UserModel> serviceResponse = userService.fetchAllUsers();
    return ResponseEntity.ok(serviceResponse);
  }

  @GetMapping(value = "getUser/{userId}")
  public ResponseEntity<UserModel> getUser(@PathVariable("userId") Integer userId) {
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

  @PostMapping(value = "uploadImage/{userId}")
  public ResponseEntity<UserModel> uploadImage(
      @RequestPart("image") MultipartFile image, @PathVariable("userId") Integer userId) {
    UserModel serviceResponse;
    try {
      serviceResponse = userService.uploadImage(image, userId);
      return ResponseEntity.ok(serviceResponse);
    } catch (IOException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(null); // TODO RETURN A RESULT MODEL
    }
  }

  @DeleteMapping(value = "deleteUser/{userId}")
  public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") Integer userId) {
    Boolean serviceResponse = userService.deleteUser(userId);
    return ResponseEntity.ok(serviceResponse);
  }
}
