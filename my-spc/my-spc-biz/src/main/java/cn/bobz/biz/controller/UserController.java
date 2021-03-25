package cn.bobz.biz.controller;

import cn.bobz.module.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 响应json格式，@RequestMapping中配置headers和produces为json格式
 * 原本默认响应json格式
 * 因为导入的eureka-client依赖里面包含jackson-dataformat-xml.jar这个jar包，把json格式转换成了xml格式。
 * 解决方法
 * 1.@RequestMapping中配置headers和produces为json格式。
 * 2.maven中在eureka-client中排除jackson-dataformat-xml。https://blog.csdn.net/weixin_41145945/article/details/106646627
 * 3.全局配置或注册配置类
 */
@RestController
@RequestMapping(path = "/biz", headers="Accept=application/json", produces="application/json;charset=UTF-8")
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
