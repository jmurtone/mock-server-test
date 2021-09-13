package com.example.mockservertest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockserver.matchers.Times.exactly;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@SpringBootTest
class MockServerTestApplicationTests {

    private static ClientAndServer mockServer;

    @BeforeAll
    static void before() {
        mockServer = new ClientAndServer(18381);
    }

    @AfterAll
    static void after() {
        mockServer.stop();
    }

    @Test
    void contextLoads() {
        System.out.println("Spring application loaded.");
    }

    @Test
    void testMock() {
        mockServer.when(request().withMethod("GET"), exactly(1))
                .respond(response("Ok buddy")
                        .withStatusCode(200)
                        .withHeaders(
                                new Header("Content-Type", "text/plain; charset=utf-8")));
    }

}
