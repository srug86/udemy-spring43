package com.srug86.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

    private static final String NOT_FOUND_VIEW = "404";
    private static final String SERVER_ERROR = "500";

    @GetMapping("/404")
    public ModelAndView getNotFoundView() {
        ModelAndView modelAndView = new ModelAndView(NOT_FOUND_VIEW);
        return modelAndView;
    }

    @GetMapping("/500")
    public ModelAndView getServerErrorView() {
        ModelAndView modelAndView = new ModelAndView(SERVER_ERROR);
        return modelAndView;
    }
}
