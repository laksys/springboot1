package com.king;

import static java.lang.System.out;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class App {
	public static void main(String... args){
		SpringApplication.run(App.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args -> {
			out.println("Let's inspect bean provider by spring boot");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			int i=1;
			out.println("----------------------------------------------");
			for(String name: beanNames)
				out.format("%d. %s\n", i++, name);
			out.println("----------------------------------------------");
		};
	}
}