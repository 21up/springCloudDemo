package com.wen.cloud;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 21up on 2020/7/21
 */

public class TestActiviti {
    @Autowired
    private ProcessEngineConfiguration processEngineConfiguration;
    @Test
    public void testGenTable(){
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine = configuration.buildProcessEngine();
        System.out.println(processEngine);
    }
}
