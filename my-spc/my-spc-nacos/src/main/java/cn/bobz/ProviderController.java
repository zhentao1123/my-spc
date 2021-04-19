package cn.bobz;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProviderController {

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return string;
    }

    @PostMapping(value = "/print")
    public String print(@RequestBody User user) {
        return "name : " + user.getName() + " , age : " + user.getAge();
    }

}
