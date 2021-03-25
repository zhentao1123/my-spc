package cn.bobz.myspcweb.controller;

import cn.bobz.module.User;
import cn.bobz.myspcweb.remote.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/", headers="Accept=application/json", produces="application/json;charset=UTF-8")
public class WebController {

    private UserClient userClient;

    @Autowired
    public void setUserClient(UserClient userClient){
        this.userClient = userClient;
    }

    @RequestMapping(path = "/getUser")
    public User getUser() {
        return userClient.getUser();
    }
}
