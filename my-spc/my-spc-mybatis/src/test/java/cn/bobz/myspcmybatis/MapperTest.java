package cn.bobz.myspcmybatis;

import cn.bobz.myspcmybatis.entity.User;
import cn.bobz.myspcmybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test1(){
        List<User> userList = userMapper.selectList(null);
        userList.forEach(u-> System.out.println(u));
    }

}
