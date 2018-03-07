package com.srug86.backendninja.component;

import com.srug86.backendninja.controller.ExampleController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponent {

    private static final Log LOG = LogFactory.getLog(ExampleController.class);

    public void sayHello() {
        LOG.info("HELLO FROM ExampleComponent");
    }
}
