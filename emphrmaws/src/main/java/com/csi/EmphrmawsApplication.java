package com.csi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EmphrmawsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmphrmawsApplication.class, args);
	}

}
