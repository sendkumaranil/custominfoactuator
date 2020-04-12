package com.custom.info.actuator.service;

import com.custom.info.actuator.data.DbInfoDetails;
import com.custom.info.actuator.model.DbInfo;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.List;

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
