package com.cauduro.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cauduro.example.entity.GrandParent;

@Repository
public interface GrandParentRepository extends JpaRepository<GrandParent, Integer> {}
