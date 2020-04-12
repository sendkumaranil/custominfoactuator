# custominfoactuator
Create Custom Info Actuator and custom info endpoint and custom actuator url path

<h3>Custom Actuator URI </h3>

http://localhost:8080/myactuator/

management.endpoints.web.base-path=/myactuator

<h3>Custom Info </h3>

<ol><li>Using Property File Configuration</li>
  <li>Customize InfoContributor Interface</li>
</ol>

<b>1.Using Property File Configuration</b>
       ``` info.app.environments=Dev
           info.app.host=localhost
           info.app.port=8080

<b>2.Customize InfoContributor Interface</b>
        ```   @Component
              public class ProjectInfoService implements InfoContributor {
                  @Override
                  public void contribute(Info.Builder builder) {
                      ProjectDetails projectDetails=ProjectInfo.getProjectDetails();
                      builder.withDetail("projectDetails",projectDetails);
                  }
              }
 
