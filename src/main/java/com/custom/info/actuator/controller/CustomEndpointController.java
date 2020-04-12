package com.custom.info.actuator.controller;

import com.custom.info.actuator.data.MappingDetails;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
