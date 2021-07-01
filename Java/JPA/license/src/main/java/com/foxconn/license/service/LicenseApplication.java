package com.foxconn.license.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@ComponentScan({"com.delivery.request"})
@EntityScan("com.foxconn.license.entity")
@EnableJpaRepositories("com.foxconn.license.entity")
public class LicenseApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicenseApplication.class, args);
	}

}
