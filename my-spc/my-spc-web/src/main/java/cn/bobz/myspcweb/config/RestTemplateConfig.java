package cn.bobz.myspcweb.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced //如果后续用RestTemplate方式rpc则该标签使RestTemplate支持负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
