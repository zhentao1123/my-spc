package cn.bobz.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix //支持熔断
public class MySpcBizApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpcBizApplication.class, args);
	}

}
