package com.srug86.backendninja.service.impl;

import com.srug86.backendninja.service.ICheckpoint1Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("checkpoint1Service")
public class Checkpoint1ServiceImpl implements ICheckpoint1Service {

    private static final Log LOG = LogFactory.getLog(Checkpoint1ServiceImpl.class);

    @Override
    public void sayHello() {
        LOG.info("HELLO FROM Checkpoint1ServiceImpl");
    }
}
