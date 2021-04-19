package cn.bobz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@RestController
public class ProviderController {

    @Value("${test}")
    private String test;

    @Value("${test-share}")
    private String testShare;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return string ;
    }

    @PostMapping(value = "/print")
    public String print(@RequestBody User user) {
        return "name : " + user.getName() + " , age : " + user.getAge();
    }

    @GetMapping(value = "/test")
    public String print() {
        return test + " : " +testShare;
    }

}
