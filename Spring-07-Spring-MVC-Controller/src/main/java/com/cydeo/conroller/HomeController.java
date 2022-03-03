package com.cydeo.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @RequestMapping("/home")
    public String home() {
        return "home.html";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome.html";
    }

    @RequestMapping //If nothing indicated default port end-point
    public String home2() {
        return "home.html";
    }
}
