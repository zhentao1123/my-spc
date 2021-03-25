package cn.bobz.myspcweb.remote;

import cn.bobz.module.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("biz-service") //所需调用的服务在eurrka中注册的名称，即服务的"spring.application.name"值
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/biz/getUser")
    User getUser();

}

