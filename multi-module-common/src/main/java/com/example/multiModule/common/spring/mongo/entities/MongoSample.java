package com.example.multiModule.common.spring.mongo.entities;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "mongoSample")
public class MongoSample {
	@Id
	private String id; 
	
	@Field("name")
	private String name;
}
