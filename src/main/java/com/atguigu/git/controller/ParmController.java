package com.atguigu.git.controller;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParmController {


    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getParms(@PathVariable("id") Integer id,
                                       @PathVariable("username") String username,
                                       @PathVariable HashMap<String,String> pv,
                                       @RequestHeader HashMap<String,String> header,
                                       @RequestHeader("Connection") String Connection,
                                       @RequestParam("age") Integer age,
                                       @RequestParam("inters") List<String> inters,
                                       @RequestParam Map<String,String> params,
                                       @CookieValue("_ga") String _ga,
                                       @CookieValue("_ga") Cookie cookie){
        Map<String,Object> map = new HashMap<>();
//        map1.put("id",id);
//        map1.put("username",username);
//        map1.put("pv",pv);
//        map1.put("header",header);
//        map1.put("Connection",Connection);

        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        map.put("_ga",_ga);
        return map;
    }





}
