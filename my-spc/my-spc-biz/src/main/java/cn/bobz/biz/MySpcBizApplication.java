package cn.bobz.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableFeignClients
@EnableWebMvc
public class MySpcBizApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpcBizApplication.class, args);
	}

}
