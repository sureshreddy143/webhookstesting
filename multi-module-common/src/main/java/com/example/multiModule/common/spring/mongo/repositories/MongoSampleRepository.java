package com.example.multiModule.common.spring.mongo.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.multiModule.common.spring.mongo.entities.MongoSample;

public interface MongoSampleRepository extends MongoRepository<MongoSample, UUID> {

}
