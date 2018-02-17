package com.srug86.backendninja.controller;

import com.srug86.backendninja.model.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/examplepost")
public class ExamplePostController {

    private static final Log LOGGER = LogFactory.getLog(ExamplePostController.class);

    private static final String FORM_VIEW = "form";
    private static final String RESULT_VIEW = "result";

    // Redirect - Example 1
//    @GetMapping("/")
//    public String redirect() {
//        return "redirect:/examplepost/showform";
//    }

    // Redirect - Example 2
    @GetMapping("/")
    public RedirectView redirect() {
        return new RedirectView("/examplepost/showform");
    }

    @GetMapping("/showform")
    public String showForm(Model model){
        LOGGER.info("INFO TRACE");
        LOGGER.warn("WARNING TRACE");
        LOGGER.error("ERROR TRACE");
        LOGGER.debug("DEBUG TRACE");
        model.addAttribute("person", new Person());
        return FORM_VIEW;
    }

    @PostMapping("/addperson")
    public ModelAndView addPerson(@ModelAttribute("person") Person person) {
        LOGGER.info("METHOD: 'addPerson' -- PARAMS: '" + person + "'");
        ModelAndView modelAndView = new ModelAndView(RESULT_VIEW);
        modelAndView.addObject("person", person);
        LOGGER.info("TEMPLATE: '" + RESULT_VIEW + "' -- DATA: '" + person + "'");
        return modelAndView;
    }
}
