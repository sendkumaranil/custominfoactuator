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
<h3>Custom endpoint with RestController</h3>
<p>http://localhost:8080/myactuator/custom-mapping/all</p>
<p>management.endpoints.web.exposure.include=dbInfo,info,custom-mapping</p>
<pre>
            @Component
            @RestControllerEndpoint(id="custom-mapping")
            public class CustomEndpointController {
            
                @GetMapping("/all")
                public List<String> getMappings(){
                    Map<String, String> mapping=MappingDetails.getMapping();
                    List<String> mappings=null;
            
                    mappings=mapping.values().stream().collect(Collectors.toList());
            
                    return mappings;
                }
            }
</pre>
<h3>Custom Health Check</h3>
<p>http://localhost:8080/myactuator/health</p>
<pre>
        @Component
        public class DbHealthCheckIndicator implements HealthIndicator {
        
            @Override
            public Health health() {
                //Check Db Connection
                boolean dbConnectionFailed=isDbConnectionFailed();
        
                if(dbConnectionFailed){
                    return Health.down().withDetail("DBConnection","FAILED").build();
                }
                return Health.up().withDetail("DBConnection","SUCCESS").build();
            }
        
            private boolean isDbConnectionFailed(){
                //code to check the db connection.
                return true;
            }
        }
</pre>
<pre>
        {
            "status": "DOWN",
            "components": {
            "dbHealthCheckIndicator": {
                "status": "DOWN",
                "details": {
                    "DBConnection": "FAILED"
                }
            },
            "diskSpace": {
            "status": "UP",
                "details": {
                "total": 121123069952,
                "free": 59155836928,
                "threshold": 10485760
                }
            },
                "ping": {
                "status": "UP"
                }
            }
        }
</pre>