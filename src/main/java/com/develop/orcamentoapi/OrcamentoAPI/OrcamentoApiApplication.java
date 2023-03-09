package com.develop.orcamentoapi.OrcamentoAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OrcamentoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrcamentoApiApplication.class, args);
	}

}
