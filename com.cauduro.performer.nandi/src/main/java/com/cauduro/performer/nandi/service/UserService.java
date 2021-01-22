package com.cauduro.performer.nandi.service;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.cauduro.performer.nandi.models.UserModel;

public interface UserService {
  List<UserModel> fetchAllUsers();

  UserModel getUser(Integer id);

  UserModel inserNewUser(UserModel model);

  UserModel updateUser(UserModel model);

  Boolean deleteUser(Integer id);

  UserModel uploadImage(MultipartFile image, Integer userId) throws IOException;
}
