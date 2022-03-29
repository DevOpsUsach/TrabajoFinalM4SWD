package com.devops.dxc.devops;
import com.devops.dxc.devops.model.UfHoy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DevopsApplication {

	private static final Logger log = LoggerFactory.getLogger(DevopsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DevopsApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			UfHoy ufHoy = restTemplate.getForObject(
				"https://mindicador.cl/api/uf/27-03-2022", UfHoy.class);
			log.info(ufHoy.toString());
		};
	}
}