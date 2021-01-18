package com.cauduro.performer.nandi.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cauduro.performer.nandi.entity.UserEntity;
import com.cauduro.performer.nandi.exception.UserRuntimeException;
import com.cauduro.performer.nandi.mapping.UserMapping;
import com.cauduro.performer.nandi.models.UserModel;
import com.cauduro.performer.nandi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository repository;
	private final UserMapping mapper;
	
	public UserServiceImpl(UserRepository repository,UserMapping mapper) {
		this.repository=repository;
		this.mapper=mapper;
	}
	
	@Override
	public UserModel getUser(UUID id) {
		UserEntity user=repository.findById(id)
				.orElseThrow(()->new UserRuntimeException("no user found"));
		return mapper.toModel(user);
	}

	@Override
	public UserModel inserNewUser(UserModel model) {
		return mapper.toModel(repository.save(mapper.toEntity(model)));
	}

	@Override
	public UserModel updateUser(UserModel model) {

		return mapper.toModel(repository.save(mapper.toEntity(model)));
	}

	@Override
	public Boolean deleteUser(UUID id) {
		getUser(id);//throw exception if user did not exist
		repository.deleteById(id);
		return true;
	}

}
