package com.erenuygur.datajpapostgresrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DataJpaPostgresRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaPostgresRestapiApplication.class, args);
	}

}
