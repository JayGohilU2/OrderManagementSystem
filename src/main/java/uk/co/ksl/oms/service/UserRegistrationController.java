package uk.co.ksl.oms.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserRegistrationController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register() {
        return "/registerNewUser";
    }

    @RequestMapping(value="/registerNewUser", method = RequestMethod.POST)
    public String registerNewUser(@RequestParam("username") String username,
                                  @RequestParam("company") String company,
                                  @RequestParam("password") String password)  {
        return "/login";
    }


}

