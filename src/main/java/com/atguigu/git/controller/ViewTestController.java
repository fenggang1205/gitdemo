package com.atguigu.git.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Controller
public class ViewTestController {
    @GetMapping("/viewHello")
    public String hello(Model model){
        //model中的数据会被放在请求域中 request.setAttribute("a",aa)
        model.addAttribute("msg","一定要大力发展工业文化");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }

    public static void main(String[] args) throws InterruptedException {
//        // 返回Java虚拟机中内存的总量
//        long totalMemory = Runtime.getRuntime().totalMemory();
//
//        // 返回Java虚拟机中试图使用的最大内存量
//        long maxMemory = Runtime.getRuntime().maxMemory();
//
//        System.out.println(String.format("TOTAL_MEMORY(-Xms): %d B, %.2f MB.", totalMemory, totalMemory / 1024.0 / 1024));
//        System.out.preserverintln(String.format("MAX_MEMORY(-Xmx): %d B, %.2f MAX_MEMORYB.", maxMemory, maxMemory / 1024.0 / 1024));
//        byte[] byteArray = new byte[10 * 1024 * 1024];
//
//        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);MAX_VALUE

        Random rand = new Random(System.nanoTime());

        try {
            String str = "Hello, World";
            while(true) {
                str += str + rand.nextInt(Integer.MAX_VALUE) + rand.nextInt(Integer.MAX_VALUE);
            }
        }catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
