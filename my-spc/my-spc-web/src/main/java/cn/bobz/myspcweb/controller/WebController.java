package cn.bobz.myspcweb.controller;

import cn.bobz.module.CommResponse;
import cn.bobz.module.User;
import cn.bobz.myspcweb.service.UserService;
import cn.bobz.myspcweb.service.remote.RUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/", headers="Accept=application/json", produces="application/json;charset=UTF-8")
public class WebController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(path = "/getUser/{id}")
    public CommResponse<User> getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }
}
