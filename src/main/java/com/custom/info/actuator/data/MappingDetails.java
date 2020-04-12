package com.custom.info.actuator.data;

import java.util.HashMap;
import java.util.Map;

public class MappingDetails {

    private static Map<String,String> mapping;

    static {
        mapping=new HashMap<>();
        mapping.put("Orders","/orders");
        mapping.put("Invoice","/invoice");
        mapping.put("Shipping","/shipping");
    }

    public static Map<String,String> getMapping(){
        return mapping;
    }
}
