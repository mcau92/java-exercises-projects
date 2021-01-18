package com.cauduro.performer.nandi.service;

import java.util.UUID;

import com.cauduro.performer.nandi.models.UserModel;

public interface UserService {

	UserModel getUser(UUID id);
	
	UserModel inserNewUser(UserModel model);

	UserModel updateUser(UserModel model);
	
	Boolean deleteUser(UUID id);

}
