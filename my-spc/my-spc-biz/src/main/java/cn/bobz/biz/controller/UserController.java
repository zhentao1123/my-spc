package cn.bobz.biz.controller;

import cn.bobz.module.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/biz")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(path = "/getUser")
    public User getUser() {
        log.info("==> Request getUser ");
        User user = new User();
        user.setName("Tom");
        user.setAge(10);
        return user;
    }

}
