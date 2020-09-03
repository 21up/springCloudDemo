package com.wen.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * Created by 21up on 2020/9/3
 */
public class ActivitiTaskQuery {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        //根据流程定义的key,负责人assignee来实现当前用户的任务列表查询
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("zhangsan")
                .list();
        for (Task task:taskList){
            System.out.println("流程实例ID"+task.getProcessInstanceId());
            System.out.println("任务ID"+task.getId());
            System.out.println("任务负责人"+task.getAssignee());
            System.out.println("任务名称"+task.getName());
        }
    }
}
