package com.company.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * User controller
 */
@Controller
public class UserController {

    @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView modelAndView = new ModelAndView();

        if (error != null) {
            modelAndView.addObject("error", "Incorrect username or password!");
        }

        if (logout != null) {
            modelAndView.addObject("logout", "Logged out successfully.");
        }

        modelAndView.setViewName("login");

        return modelAndView;
    }
}
