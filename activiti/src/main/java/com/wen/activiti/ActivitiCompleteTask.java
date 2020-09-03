package com.wen.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * Created by 21up on 2020/9/3
 */
public class ActivitiCompleteTask {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        //处理任务
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("zhangsan")
                .list();
        for (Task task:taskList){
            System.out.println("流程实例ID"+task.getProcessInstanceId());
            System.out.println("任务ID"+task.getId());
            System.out.println("任务负责人"+task.getAssignee());
            System.out.println("任务名称"+task.getName());
            taskService.complete(task.getId());
            System.out.println("任务"+task.getId()+"已完成");
        }
    }
}
