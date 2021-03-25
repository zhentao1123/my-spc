package cn.bobz.myspcweb.remote;

import cn.bobz.module.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("user")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/getUser")
    User getUser();

}
