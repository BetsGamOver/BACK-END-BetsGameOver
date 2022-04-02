package edu.eci.ieti.betsGameOverApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.ieti.betsGameOver"})
//@EnableMongoRepositories("edu.eci.ieti.betsGameOver.repository")
public class BetsGameOverApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetsGameOverApplication.class, args);
	}
}