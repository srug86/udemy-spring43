package com.srug86.backendninja.controller;

import com.srug86.backendninja.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/example")
public class ExampleController {

    private static final String EXAMPLE_1_VIEW = "example1";
    private static final String EXAMPLE_2_VIEW = "example2";
    private static final String EXAMPLE_3_VIEW = "example3";
    private static final String ATTRIBUTE_NAME = "name";
    private static final String ATTRIBUTE_PERSON = "person";
    private static final String ATTRIBUTE_PEOPLE = "people";

    // Example 1 - One Way --> Mainly used to redirects
    @GetMapping("/exampleString")
    public String exampleString(Model model) {
        model.addAttribute(ATTRIBUTE_NAME, "John");
        return EXAMPLE_1_VIEW;
    }

    // Example 1 - Another Way --> Mainly used to return views and data
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV() {
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_1_VIEW);
        modelAndView.addObject(ATTRIBUTE_NAME, "Michael");
        return modelAndView;
    }


    // Example 2 - Using Objects
    @GetMapping("/examplePerson")
    public String examplePerson(Model model) {
        model.addAttribute(ATTRIBUTE_PERSON, new Person("John", 24));
        return EXAMPLE_2_VIEW;
    }

    @GetMapping("/exampleMAVPerson")
    public ModelAndView exampleMAVPerson() {
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_2_VIEW);
        modelAndView.addObject(ATTRIBUTE_PERSON, new Person("Michael", 30));
        return modelAndView;
    }

    // Example 3 - Using Collections
    @GetMapping("/examplePeople")
    public String examplePeople(Model model) {
        model.addAttribute(ATTRIBUTE_PEOPLE, getPeople());
        return EXAMPLE_3_VIEW;
    }

    @GetMapping("/exampleMAVPeople")
    public ModelAndView exampleMAVPeople() {
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_3_VIEW);
        modelAndView.addObject(ATTRIBUTE_PEOPLE, getPeople());
        return modelAndView;
    }

    private List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 24));
        people.add(new Person("Jane", 22));
        people.add(new Person("Michael", 30));
        people.add(new Person("Peter", 31));
        return people;
    }
}
