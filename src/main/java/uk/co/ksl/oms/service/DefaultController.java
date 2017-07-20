package uk.co.ksl.oms.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @RequestMapping("/")
    public String home() {
        return "/home";
    }

    @RequestMapping("/home")
    public String home2() {
        return "/home";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }
}
