package com.wen.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * Created by 21up on 2020/9/3
 */
public class ActivitiStartInstance {
    public static void main(String[] args) {
        //1.得到processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //3.创建流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday");
        //4.输出实例的相关信息
        System.out.println("流程部署ID+"+processInstance.getDeploymentId());
        System.out.println("流程定义ID+"+processInstance.getProcessDefinitionId());
        System.out.println("流程实例ID"+processInstance.getId());
        System.out.println("活动/节点ID"+processInstance.getActivityId());
    }
}
