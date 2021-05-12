package com.fundy.statisticservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.fundy"})
@SpringBootApplication
public class StatisticServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatisticServiceApplication.class, args);
	}

}
