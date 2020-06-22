package cn.bobz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(path = "/biz")
public class MySpcBizApplication {

	private static final Logger log = LoggerFactory.getLogger(MySpcBizApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MySpcBizApplication.class, args);
	}

	@RequestMapping(path = "/getUser")
	public User getUser() {
		log.info("==> Request getUser ");
		User user = new User();
		user.setName("Tom");
		user.setAge(10);
		return user;
	}
	
	public static final class User{
		private String name;
		private Integer age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
	}
	
}
