package com.custom.info.actuator.data;

import com.custom.info.actuator.model.DbInfo;

import java.util.ArrayList;
import java.util.List;

public class DbInfoDetails {

    private static List<DbInfo> dbInfos;

    static {
        dbInfos=new ArrayList<>();

        DbInfo dbInfoDev=new DbInfo();
        dbInfoDev.setHost("100.102.103.10");
        dbInfoDev.setPort("6162");
        dbInfoDev.setDbVendor("Oracle");
        dbInfoDev.setServiceName("USERDETAILS");
        dbInfoDev.setEnv("DEV");

        DbInfo dbInfoUat=new DbInfo();
        dbInfoUat.setHost("100.102.103.15");
        dbInfoUat.setPort("6163");
        dbInfoUat.setDbVendor("Oracle");
        dbInfoUat.setServiceName("USERDETAILS");
        dbInfoUat.setEnv("UAT");

        DbInfo dbInfoProd=new DbInfo();
        dbInfoProd.setHost("112.119.43.23");
        dbInfoProd.setPort("6164");
        dbInfoProd.setDbVendor("Oracle");
        dbInfoProd.setServiceName("USERDETAILSPROD");
        dbInfoProd.setEnv("PROD");

        dbInfos.add(dbInfoDev);
        dbInfos.add(dbInfoUat);
        dbInfos.add(dbInfoProd);
    }

    public static List<DbInfo> getDbInfos(){
        return dbInfos;
    }
}
