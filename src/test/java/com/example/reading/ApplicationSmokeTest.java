package com.example.reading;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApplicationSmokeTest {
	@Autowired
	private WebController webController;

	@Autowired
	private ReadingApplication readingApplication;

	@Test
	void controllerLoads() {
		assertThat(webController).isNotNull();
	}

	@Test
	void applicationLoads() {
		assertThat(readingApplication).isNotNull();
	}
}
