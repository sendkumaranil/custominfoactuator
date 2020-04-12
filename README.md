# custominfoactuator
Create Custom Info Actuator and custom info endpoint and custom actuator url path

<h3>Custom Actuator URI </h3>

<p>http://localhost:8080/myactuator/</p>

<p>http://localhost:8080/myactuator/info</p>

<p>management.endpoints.web.base-path=/myactuator</p>

<h3>Custom Info </h3>

<ol><li>Using Property File Configuration</li>
  <li>Customize InfoContributor Interface</li>
</ol>

<b>1.Using Property File Configuration</b>
       <pre>info.app.environments=Dev
       info.app.host=localhost
       info.app.port=8080</pre>

<b>2.Customize InfoContributor Interface</b>
       <pre>@Component
            public class ProjectInfoService implements InfoContributor {
                  @Override
                  public void contribute(Info.Builder builder) {
                      ProjectDetails projectDetails=ProjectInfo.getProjectDetails();
                      builder.withDetail("projectDetails",projectDetails);
                  }
            }
      </pre>
 
<h3>Custom Info Endpoints (URI) </h3>
<p>http://localhost:8080/myactuator/dbInfo</p>
<p>http://localhost:8080/myactuator/dbInfo/uat</p>

<p>management.endpoints.web.exposure.include=dbInfo,info</p>

<pre>
          @Component
          @Endpoint(id="dbInfo")
          public class CustomDbInfoEndpoint {

              @ReadOperation
              public List<DbInfo> dbInfo(){
                  List<DbInfo> dbInfos= DbInfoDetails.getDbInfos();
                  return dbInfos;
              }

              @ReadOperation
              public DbInfo getDbInfoByEnvironment(@Selector String envName){

                  List<DbInfo> dbInfos= DbInfoDetails.getDbInfos();

                  DbInfo dbByEnv=dbInfos.stream().filter(dbinfo -> dbinfo.getEnv().equalsIgnoreCase(envName))
                          .findFirst()
                          .get();
                  return dbByEnv;
              }
          }
</pre>
