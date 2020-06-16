package cn.bobz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MySpcEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpcEurekaApplication.class, args);
	}

}
