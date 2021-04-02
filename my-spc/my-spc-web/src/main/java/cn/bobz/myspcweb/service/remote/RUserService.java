package cn.bobz.myspcweb.service.remote;

import cn.bobz.module.CommResponse;
import cn.bobz.module.User;
import cn.bobz.myspcweb.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        value = "biz-service" //所需调用的服务在eurrka中注册的名称，即服务的"spring.application.name"值
        , fallback = RUserServiceFallback.class
//        , configuration = FeignConfig.class
)
public interface RUserService {

    @RequestMapping(method = RequestMethod.GET, value = "/biz/getUser/{id}")
    CommResponse<User> getUser(@PathVariable("id") Integer id);

}

