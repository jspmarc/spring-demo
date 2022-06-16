package dev.jspmarc.springdemo.rest.web.controller;

import dev.jspmarc.springdemo.entity.constant.ApiPath;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPath.BASE_FAVORITE_PATH)
public class FavoriteController {

    @GetMapping(ApiPath.ROOT)
    public String[] getFavorites() {
        return new String[]{"A"};
    }

    @PostMapping(ApiPath.ROOT)
    @ResponseStatus(code = HttpStatus.CREATED)
    public String favoritesUser(@RequestBody String name) {
        return name;
    }
}
