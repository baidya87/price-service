package com.baidya.cognizant.resource;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceResourceWithServerStartTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testWelcome(){
        Assertions.assertThat(this.testRestTemplate.getForObject("/prices/test", String.class)).contains("Welcome ^^ test!");

    }
}
