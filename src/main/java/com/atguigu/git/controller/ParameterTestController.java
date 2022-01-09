package com.atguigu.git.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ParameterTestController {

    @GetMapping("/cars/{path}")
    public Map<String,Object> carsSell(@MatrixVariable("low") String low,
                                       @MatrixVariable("brand") String brand,
                                       @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }
}
