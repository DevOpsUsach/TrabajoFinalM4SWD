package com.devops.dxc.devops;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DevopsApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {

	}

	// @Test
	// public void rutaInicialDeberiaDevolverMensajeBienvenida() throws Exception {

	// assertThat(this.restTemplate.getForObject("http://localhost:" + port +
	// "/rest/msdxc/", String.class))
	// .contains("Hello World");

	// }

}
