package com.cauduro.performer.nandi.service;

import java.util.List;
import com.cauduro.performer.nandi.models.UserModel;

public interface UserService {
  List<UserModel> fetchAllUsers();

  UserModel getUser(Integer id);

  UserModel inserNewUser(UserModel model);

  UserModel updateUser(UserModel model);

  Boolean deleteUser(Integer id);
}
