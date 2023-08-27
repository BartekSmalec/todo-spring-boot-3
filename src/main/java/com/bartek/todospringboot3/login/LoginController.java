package com.bartek.todospringboot3.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class LoginController {

    @RequestMapping("login")
    public String sayHelloJsp(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        return "login";
    }
}
