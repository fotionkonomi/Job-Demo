package de.dh.lhind.demo.jobapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"de.dh.lhind.demo.jobapi",
		"de.dh.lhind.demo.jobcore"})
public class JobApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobApiApplication.class, args);
	}

}
