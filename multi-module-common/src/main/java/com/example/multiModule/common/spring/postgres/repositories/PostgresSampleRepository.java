package com.example.multiModule.common.spring.postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.multiModule.common.spring.postgres.entities.PostgresSample;

public interface PostgresSampleRepository extends JpaRepository<PostgresSample, Integer> {

}
