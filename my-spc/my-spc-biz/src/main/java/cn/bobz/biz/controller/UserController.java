package cn.bobz.biz.controller;

import cn.bobz.module.CommResponse;
import cn.bobz.module.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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

    @RequestMapping(path = "/getUser/{id}")
    public CommResponse<User> getUser(@PathVariable("id") Integer id) {
        log.info("==> Request getUser ");
        User user = new User();
        user.setId(id);
        user.setName("Tom");
        user.setAge(10);
        return CommResponse.getInstances4Succeed(user);
    }

    // ============================================================================

    /**
     * 演示超时
     * @return
     */
    @RequestMapping(path = "/getUser1/{id}")
    @HystrixCommand(fallbackMethod = "getUserTimeout",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public CommResponse<User> getUser1(@PathVariable("id") Integer id){
        log.info("==> Request getUser1 ");
        int timeNumber = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setId(id);
        user.setName("Tom");
        user.setAge(10);
        return CommResponse.getInstances4Succeed(user);
    }
    public CommResponse<User> getUserTimeout(Integer id){
        return CommResponse.getInstances4Fail("Get user timeout");
    }

    // ============================================================================

    /**
     * 熔断
     * @return
     */
    @RequestMapping(path = "/getUser2/{id}")
    @HystrixCommand(fallbackMethod = "getUserCallback",commandProperties ={
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "2"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),//失败率达到多少后跳闸
    })
    public CommResponse<User> getUser2(@PathVariable("id") Integer id){
        log.info("==> Request getUser2 "); //触发熔断则不会打印
        if (id < 1) {
            throw new RuntimeException("id 不能为负数");
        }
        User user = new User();
        user.setId(id);
        user.setName("Tom");
        user.setAge(10);
        return CommResponse.getInstances4Succeed(user);
    }
    public CommResponse<User> getUserCallback(Integer id){
        return CommResponse.getInstances4Fail("Get user Fail");
    }

}
