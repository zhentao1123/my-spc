package cn.bobz.myspcweb.service.remote;

import cn.bobz.module.CommResponse;
import cn.bobz.module.User;

public class RUserServiceFallback implements RUserService{

    @Override
    public CommResponse<User> getUser(Integer id) {
        return CommResponse.getInstances4Fail("Call GetUser Fail");
    }
}
