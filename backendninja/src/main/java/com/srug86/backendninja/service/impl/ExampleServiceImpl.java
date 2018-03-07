package com.srug86.backendninja.service.impl;

import com.srug86.backendninja.model.Person;
import com.srug86.backendninja.service.IExampleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("exampleService")
public class ExampleServiceImpl implements IExampleService {

    private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

    @Override
    public List<Person> getListPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 24));
        people.add(new Person("Jane", 22));
        people.add(new Person("Michael", 30));
        people.add(new Person("Peter", 31));
        LOG.info("HELLO FROM ExampleServiceImpl");
        return people;
    }
}
