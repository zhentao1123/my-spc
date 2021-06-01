package cn.bobz.myspcmybatis;

import cn.bobz.myspcmybatis.entity.User;
import cn.bobz.myspcmybatis.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {

    @Autowired
    IUserService userService;

    @Test
    public void test2(){
        List<User> userList = userService.list();
        userList.forEach(u-> System.out.println(u));
    }

}
