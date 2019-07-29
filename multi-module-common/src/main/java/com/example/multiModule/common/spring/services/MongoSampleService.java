package com.example.multiModule.common.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.multiModule.common.spring.mongo.entities.MongoSample;
import com.example.multiModule.common.spring.mongo.repositories.MongoSampleRepository;

@Service
public class MongoSampleService {
	@Autowired
	MongoSampleRepository mongoSampleRepository;
	
	public List<MongoSample> findAll() {
		return mongoSampleRepository.findAll();
	}
	public MongoSample save(MongoSample mongoSample) {
		return mongoSampleRepository.save(mongoSample);
	}
}
