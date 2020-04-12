package com.custom.info.actuator.data;

import com.custom.info.actuator.model.ProjectDetails;

public class ProjectInfo {

    private static ProjectDetails projectDetails;

    static {
        projectDetails=new ProjectDetails();
        projectDetails.setProjectName("Custom Info Actuator");
        projectDetails.setBuildNo(224);
        projectDetails.setVersion("1.1.0");
        projectDetails.setLastUpdated("2020-04-12");
    }

    public static ProjectDetails getProjectDetails(){
        return projectDetails;
    }
}
