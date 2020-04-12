package com.custom.info.actuator.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

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
