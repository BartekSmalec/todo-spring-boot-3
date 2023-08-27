package com.bartek.todospringboot3.login;

import com.bartek.todospringboot3.service.AuthenticationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@AllArgsConstructor
public class LoginController {

    private final AuthenticationService authenticationService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String goToLoginPage() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        model.addAttribute("name", name);
        if (authenticationService.authentication(name, password)) {
            return "welcome";
        }
        model.put("errorMessage", "Invalid Credentials");
        return "login";
    }

}
