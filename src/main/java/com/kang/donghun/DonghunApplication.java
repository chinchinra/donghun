package com.kang.donghun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DonghunApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonghunApplication.class, args);
	}

	@Bean(name = "uploadPath")
	public String uploadPath() {
		return "d:/image/";
	}
}
