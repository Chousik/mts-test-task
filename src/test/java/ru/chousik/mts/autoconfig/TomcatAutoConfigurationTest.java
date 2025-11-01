package ru.chousik.mts.autoconfig;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import javax.swing.text.html.parser.Entity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TomcatAutoConfigurationTest {
    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void testSimpleCase(){
        String url = "http://localhost:" + port + "/simple-case";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        Assertions.assertEquals("Bar", response.getHeaders().getFirst("Foo"));
    }

    @Test
    void testWithCustomFoo(){
        String url = "http://localhost:" + port + "/with-custom-foo";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        Assertions.assertEquals("Bar", response.getHeaders().getFirst("Foo"));
    }
}
