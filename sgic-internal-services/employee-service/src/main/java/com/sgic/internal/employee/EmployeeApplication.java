package com.sgic.internal.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.sgic.internal.employee.config.FileStorageProperties;


@SpringBootApplication
@EnableConfigurationProperties({ FileStorageProperties.class })
public class EmployeeApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
}