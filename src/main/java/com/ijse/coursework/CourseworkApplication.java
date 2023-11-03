package com.ijse.coursework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CourseworkApplication {

/*	@Autowired
	private UserRoleService userRoleService;*/
	public static void main(String[] args) {
		SpringApplication.run(CourseworkApplication.class, args);
	}

/*
	@Override
	public void run(String... args) throws Exception {
		userRoleService.initializeRoles();
	}*/
}
