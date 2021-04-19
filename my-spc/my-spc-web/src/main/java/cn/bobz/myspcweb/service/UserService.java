package cn.bobz.myspcweb.service;

import cn.bobz.module.CommResponse;
import cn.bobz.module.User;
import cn.bobz.myspcweb.service.remote.RUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    // == Feign方式 ===========================
    private RUserService rUserService;

    @Autowired
    public void setRUserService(RUserService rUserService){
        this.rUserService = rUserService;
    }

    // == RestTemplate方式 ======================================

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate){
        this.restTemplate =  restTemplate;
    }

    // ==============================================

    public CommResponse<User> getUser(Integer id){
        // Feign方式
        //return rUserService.getUser(id);
        // RestTemplate方式
        return restTemplate.getForObject("http://biz-service/biz/getUser/"+id, CommResponse.class);
    }
}
