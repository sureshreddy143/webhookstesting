package com.example.multiModule.common.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.multiModule.common.spring.postgres.entities.PostgresSample;
import com.example.multiModule.common.spring.postgres.repositories.PostgresSampleRepository;

@Service
public class PosgresSampleService {
	@Autowired
	PostgresSampleRepository postgresSampleRepository;
	public List<PostgresSample> findAll() {
		return postgresSampleRepository.findAll();
	}
	public PostgresSample save(PostgresSample postgresSample) {
		return postgresSampleRepository.save(postgresSample);
	}
}
