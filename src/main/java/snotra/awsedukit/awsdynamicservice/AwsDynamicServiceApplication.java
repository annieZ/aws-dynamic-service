package snotra.awsedukit.awsdynamicservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class AwsDynamicServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsDynamicServiceApplication.class, args);
	}

}
