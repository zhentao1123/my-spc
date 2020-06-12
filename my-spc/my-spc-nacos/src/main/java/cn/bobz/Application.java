package cn.bobz;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	
	// -- Provider Side --
	
	@RestController
 	public class EchoController {
 		@GetMapping(value = "/echo/{string}")
 		public String echo(@PathVariable String string) {
 				return string;
 		}
 		
 		@PostMapping(value = "/print")
 		public String print(@RequestBody User user) {
 			return "name : " + user.getName() + " , age : " + user.getAge();
 		}
 	}
	
	private static class User implements Serializable{
		private static final long serialVersionUID = 1990568015794727362L;
		
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
	
	
	
	// -- Consumer Side --
	
	@Value("${spring.application.name}")
	private String serviceProvider;
	
	@LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	@RestController
    public class TestController {

        private final RestTemplate restTemplate;

        @Autowired
        public TestController(RestTemplate restTemplate) {
        	this.restTemplate = restTemplate;
        }

        @RequestMapping(value = "/call-echo/{str}", method = RequestMethod.GET)
        public String echo(@PathVariable String str) {
            return restTemplate.getForObject("http://"+serviceProvider+"/echo/" + str, String.class);
        }
        
        @RequestMapping(value = "/call-print", method = RequestMethod.POST)
        public String print(@RequestBody User user) {
        	return restTemplate.postForObject("http://"+serviceProvider+"/print", user, String.class);
        }
    }
}
