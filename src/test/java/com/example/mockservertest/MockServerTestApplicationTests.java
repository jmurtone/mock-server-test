package com.example.mockservertest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MockServerTestApplicationTests {

	private static ClientAndServer mockServer;

	@BeforeAll
	static void before(){
		mockServer = new ClientAndServer(18381);
	}

	@AfterAll
	static void after(){
		mockServer.stop();
	}

	@Test
	void contextLoads() {
		System.out.println("Spring application loaded.");
	}

}
