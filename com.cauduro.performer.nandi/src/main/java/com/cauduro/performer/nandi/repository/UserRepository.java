package com.cauduro.performer.nandi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cauduro.performer.nandi.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {}
