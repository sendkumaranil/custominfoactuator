package com.custom.info.actuator.service;

import com.custom.info.actuator.data.ProjectInfo;
import com.custom.info.actuator.model.ProjectDetails;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class ProjectInfoService implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        ProjectDetails projectDetails=ProjectInfo.getProjectDetails();
        builder.withDetail("projectDetails",projectDetails);
    }
}
