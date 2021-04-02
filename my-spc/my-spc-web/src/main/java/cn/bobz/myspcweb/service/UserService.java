package cn.bobz.myspcweb.service;

import cn.bobz.module.CommResponse;
import cn.bobz.module.User;
import cn.bobz.myspcweb.service.remote.RUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {

    private RUserService rUserService;

    @Autowired
    public void setRUserService(RUserService rUserService){
        this.rUserService = rUserService;
    }

    public CommResponse<User> getUser(Integer id){
        return rUserService.getUser(id);
    }

}
