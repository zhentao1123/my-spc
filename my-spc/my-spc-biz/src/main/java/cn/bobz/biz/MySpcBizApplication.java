package cn.bobz.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MySpcBizApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpcBizApplication.class, args);
	}

}
