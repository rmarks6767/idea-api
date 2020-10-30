package org.csh.ideaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("org.csh.ideaapi.data.entity")
@EnableJpaRepositories("org.csh.ideaapi.data.dao")
@EnableAutoConfiguration
@SpringBootApplication
public class IdeaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdeaApiApplication.class, args);
	}

}
