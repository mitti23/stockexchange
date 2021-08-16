package com.stockexchange.joedonedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.stockexchange.joedonedata","com.stockexchange.joedonedata.controller",
		"com.stockexchange.joedonedata.service.impl","com.stockexchange.joedonedata.service","com.stockexchange.joedonedata.repository.model","com.stockexchange.joedonedata.repository"})
@EntityScan("com.stockexchange.joedonedata.repository.model")
@EnableJpaRepositories("com.stockexchange.joedonedata.repository")
@EnableAutoConfiguration
public class JoedonedataApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoedonedataApplication.class, args);
	}

}
