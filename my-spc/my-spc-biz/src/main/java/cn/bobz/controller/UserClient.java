package cn.bobz.controller;

import cn.bobz.module.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("user")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/getUser")
    public User getUser();

}
