package com.wen.cloud;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
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
    //简单的生成表的方法
    @Test
    public void testSimpleGenTable(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);
    }
    @Test
    public void startProcessInstance(){
        String processDefinitionKey = "holiday";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
        System.out.println("流程定义ID:"+processInstance.getProcessDefinitionId());
        System.out.println("流程实例ID:"+processInstance.getId());
        System.out.println("当前活动ID:"+processInstance.getActivityId());
    }
}
