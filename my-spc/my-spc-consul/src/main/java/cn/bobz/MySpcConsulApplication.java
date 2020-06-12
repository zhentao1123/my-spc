package cn.bobz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MySpcConsulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpcConsulApplication.class, args);
	}
	
}
