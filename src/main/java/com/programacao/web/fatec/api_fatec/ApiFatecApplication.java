package com.programacao.web.fatec.api_fatec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;//import adicionado manualmente
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan; //fim do import


//inicio scan
@EnableJpaRepositories("com.programacao.domain.cliente")
@EntityScan("com.programacao.web.fatec.api_fatec.entities") //fim scan
@SpringBootApplication(scanBasePackages = "com.programacao") //parentese adicionado manualmente
public class ApiFatecApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFatecApplication.class, args);
	}

}
