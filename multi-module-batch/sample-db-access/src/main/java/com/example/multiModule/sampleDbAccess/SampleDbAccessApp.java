package com.example.multiModule.sampleDbAccess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.multiModule.common.spring.mongo.entities.MongoSample;
import com.example.multiModule.common.spring.postgres.entities.PostgresSample;
import com.example.multiModule.common.spring.services.MongoSampleService;
import com.example.multiModule.common.spring.services.PosgresSampleService;

@SpringBootApplication
@ComponentScan(basePackages = { "${packages.common.component}", "${app.packages}" })
public class SampleDbAccessApp implements ApplicationRunner {
	@Autowired
	PosgresSampleService postgresSampleService;
	@Autowired
	MongoSampleService mongoSampleService;
	
	public static void main(String[] args) {
		SpringApplication.run(SampleDbAccessApp.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		PostgresSample postgre = new PostgresSample();
		postgre.setName("John");
		postgresSampleService.save(postgre);
		List<PostgresSample> findResult1 = postgresSampleService.findAll();
		findResult1.forEach(System.out::println);
		
		MongoSample mongo = new MongoSample();
		mongo.setName("Kate");
		mongoSampleService.save(mongo);
		List<MongoSample> findResult2 = mongoSampleService.findAll();
		findResult2.forEach(System.out::println);
	}
}
