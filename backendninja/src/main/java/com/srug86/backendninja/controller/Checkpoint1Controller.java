package com.srug86.backendninja.controller;

import com.srug86.backendninja.service.ICheckpoint1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/checkpoint1")
public class Checkpoint1Controller {

    private static final String CHECKPOINT1_VIEW = "checkpoint1";
    private static final String ATTRIBUTE_NAME = "result";

    @Autowired
    @Qualifier("checkpoint1Service")
    private ICheckpoint1Service iCheckpoint1Service;

    @GetMapping("/method1")
    public RedirectView method1() {
        return new RedirectView("/checkpoint1/method2");
    }

    @GetMapping("/method2")
    public ModelAndView method2() {
        iCheckpoint1Service.sayHello();
        ModelAndView modelAndView = new ModelAndView(CHECKPOINT1_VIEW);
        modelAndView.addObject(ATTRIBUTE_NAME, "mensaje");
        return modelAndView;
    }
}
