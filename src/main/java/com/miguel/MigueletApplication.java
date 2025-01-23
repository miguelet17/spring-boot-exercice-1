package com.miguel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.*;
import org.springframework.data.jpa.repository.config.*;

@SpringBootApplication(scanBasePackages={"com.miguel.*"})
@EntityScan(basePackages = {"com.miguel.persistence.*"})
@EnableJpaRepositories(basePackages = {"com.miguel.persistence.*"})
public class MigueletApplication {

	public static void main(String[] args) {
		SpringApplication.run(MigueletApplication.class, args);
	}


}
