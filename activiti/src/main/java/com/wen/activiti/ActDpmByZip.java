package com.wen.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * Created by 21up on 2020/9/3
 */
public class ActDpmByZip {
    public static void main(String[] args) {
        ProcessEngine processengine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processengine.getRepositoryService();
        InputStream is = ActDpmByZip.class.getClassLoader().getResourceAsStream("diagram/holidayBPMN.zip");
        ZipInputStream zipInputStream = new ZipInputStream(is);
        repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name("请假申请流程")
                .deploy();
    }
}
