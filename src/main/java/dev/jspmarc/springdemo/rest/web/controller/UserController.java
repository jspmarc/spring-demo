package dev.jspmarc.springdemo.rest.web.controller;

import dev.jspmarc.springdemo.entity.constant.ApiPath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPath.BASE_USER_PATH)
public class UserController {

    @GetMapping(ApiPath.ROOT)
    public String[] getRandomUsers() {
        return new String[]{"A", "B", "C"};
    }
}
