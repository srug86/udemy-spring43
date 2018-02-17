package com.srug86.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/otherexample")
public class OtherExampleController {

    private static final String OTHER_EXAMPLE_VIEW = "otherexample";

    // localhost:8084/otherexample/request1?nm=JOHN
    // localhost:8084/otherexample/request1?nm=MICHAEL
    @GetMapping("/request1")
    public ModelAndView request1(@RequestParam(name="nm", defaultValue = "you") String name) {
        ModelAndView modelAndView = new ModelAndView(OTHER_EXAMPLE_VIEW);
        modelAndView.addObject("nm_in_model", name);
        return modelAndView;
    }

    // localhost:8080/otherexample/request2/JOHN
    // localhost:8080/otherexample/request2/MICHAEL
    @GetMapping("/request2/{nm}")
    public ModelAndView request2(@PathVariable(name="nm") String name) {
        ModelAndView modelAndView = new ModelAndView(OTHER_EXAMPLE_VIEW);
        modelAndView.addObject("nm_in_model", name);
        return modelAndView;
    }
}
