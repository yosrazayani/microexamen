package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Formation;

public interface FormationRepository  extends MongoRepository<Formation, String> {

}

