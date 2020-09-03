package com.wen.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * Created by 21up on 2020/9/2
 * 流程定义部署
 */
public class ActivitiDeployment {
    public static void main(String[] args) {
        //1.创建processEngine实例
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到repositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday.bpmn")
                .addClasspathResource("diagram/holiday.png")
                .name("请假流程申请")
                .deploy();
        //4.验证部署的信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }
}
