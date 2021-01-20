package com.cauduro.performer.nandi.service;

import java.util.List;
import java.util.stream.Collectors;
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

  public UserServiceImpl(UserRepository repository, UserMapping mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public List<UserModel> fetchAllUsers() {
    return repository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
  }

  @Override
  public UserModel getUser(String id) {
    UserEntity user =
        repository.findById(id).orElseThrow(() -> new UserRuntimeException("no user found"));
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
  public Boolean deleteUser(String id) {
    getUser(id); // throw exception if user did not exist
    repository.deleteById(id);
    return true;
  }
}
