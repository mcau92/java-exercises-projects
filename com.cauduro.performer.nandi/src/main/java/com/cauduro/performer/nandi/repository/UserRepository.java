package com.cauduro.performer.nandi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cauduro.performer.nandi.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

}
