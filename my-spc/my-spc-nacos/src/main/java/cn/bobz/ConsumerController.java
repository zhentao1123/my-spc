package cn.bobz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Value("${spring.application.name}")
    private String serviceProvider;

    private RestTemplate restTemplate;

    @Autowired
    public ConsumerController(RestTemplate restTemplate) {
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

    @RequestMapping(value = "/call-test", method = RequestMethod.GET)
    public String test() {
        return restTemplate.getForObject("http://"+serviceProvider+"/test", String.class);
    }
}
