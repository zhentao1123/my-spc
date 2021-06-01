package cn.bobz.myspcmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("cn.bobz.myspcmybatis.mapper")
@SpringBootApplication
public class MySpcMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpcMybatisApplication.class, args);
    }

}
