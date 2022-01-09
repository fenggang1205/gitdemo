package com.atguigu.git.config;


import com.atguigu.git.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:beans.xml")
public class MyConfig {

    @Bean
    public User user01(){
        return new User("zahngsan",18);
    }
}
