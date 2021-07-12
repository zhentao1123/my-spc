package cn.bobz.myspcoauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pdu")
public class ProductControll {

    @GetMapping(value = "/{id}")
    public String getPdu(@PathVariable String id) {
        return "product id : " + id;
    }

}
