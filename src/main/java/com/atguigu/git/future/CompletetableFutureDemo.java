package com.atguigu.git.future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletetableFutureDemo {

        public static  ExecutorService executor = Executors.newFixedThreadPool(3);

        public static void main(String[] args) throws ExecutionException, InterruptedException {
//            System.out.println("main线程 。。。。。。start");
//            CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
//                int i = 10 / 0;
//                return i;
//            }, executor).whenComplete((res,exp) ->{
//                System.out.println("运行结果=" + res);
//                System.out.println("运行异常结果=" + exp);
//            }).exceptionally(throwable -> {
//                return 10;
//            });
//            Integer integer = integerCompletableFuture.get();
////            System.out.println(integer);
//            System.out.println("main线程............end" + integer);

            System.out.println("main线程 。。。。。。start");
//            CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
//                System.out.println( "当前线程 " + Thread.currentThread().getId());
//                int i = 10 / 2;
//                System.out.println("当前结果为" + i);
//                return i;
//            }, executor).handle((res,exp) ->{
//                if(null != res){
//                    return res * 2;
//                }
//                if(exp != null){
//                    return 0;
//                }
//                return 0;
//            });

            /**
             * 线程串行化
             *   thenRun 不能获取到前面的结果
             *
             */
//            CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
//                System.out.println("当前线程 " + Thread.currentThread().getId());
//                int i = 10 / 2;
//                System.out.println("当前结果为" + i);
//                return i;
//            }, executor).thenRunAsync(() -> {
//                System.out.println("任务2启动了");
//            }, executor);
////            System.out.println(integer);
//            System.out.println("main线程............end......" +  "结果=" );

//            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
//                System.out.println("当前线程 " + Thread.currentThread().getId());
//                int i = 10 / 2;
//                System.out.println("当前结果为" + i);
//                return i;
//            }, executor).thenAcceptAsync(res -> {
//                System.out.println("执行结果为" + res);
//            }, executor);// void accept(T t);


//            CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
//                System.out.println("当前线程 " + Thread.currentThread().getId());
//                int i = 10 / 2;
//                System.out.println("当前结果为" + i);
//                return i;
//            }, executor).thenApplyAsync(res -> {
//                return res;
//            }, executor);
//
//            CompletableFuture<Integer> future01 = CompletableFuture.supplyAsync(() -> {
//                System.out.println("任务1开始 ");
//                int i = 10 / 2;
//                System.out.println("任务1结束 ");
//                return i;
//            }, executor);
//            CompletableFuture<String> future02 = CompletableFuture.supplyAsync(() -> {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("任务2开始 ");
//                return "hello world";
//            }, executor);

//            future01.thenAcceptBothAsync(future02,(f1,f2)->{// void accept(T t, U u);
//                System.out.println("任务3开始 之前的结果为" + f1 + "   " + f2);
//            },executor);
//            CompletableFuture<String> stringCompletableFuture = future01.thenCombineAsync(future02, (f1, f2) -> {
//                return f1 + f2;
//            }, executor);
//            System.out.println(stringCompletableFuture.get());
//            future01.runAfterEitherAsync(future02,()->{
//                System.out.println("任务3开始");
//            },executor);
//            CompletableFuture<String> futureAttr = CompletableFuture.supplyAsync(() -> {
//                System.out.println("查询商品属性");
//                return "黑色";
//            }, executor);
//            CompletableFuture<String> futureImg = CompletableFuture.supplyAsync(() -> {
//                System.out.println("查询商品图片");
//                return "hello.jpg";
//            }, executor);
//            CompletableFuture<String> futureDesc = CompletableFuture.supplyAsync(() -> {
//                System.out.println("查询商品描述");
//                return "华为手机";
//            }, executor);
//
//            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(futureAttr, futureDesc, futureImg);
//            voidCompletableFuture.join();
//            System.out.println(futureAttr.get());
//            System.out.println("main线程 ......end");end
            List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
            List<Integer> integers1 = Collections.synchronizedList(new ArrayList<>());
            CompletableFuture[] completableFutures = integers.stream().map(t -> {
                return CompletableFuture.supplyAsync(() -> {
                    return checkNum(t);
                }).whenComplete((res, exp) -> {
                    if (res) {
                        integers1.add(t);
                    }
                });
            }).toArray(CompletableFuture[]::new);

            CompletableFuture.allOf(completableFutures).join();
            System.out.println(integers);

        }

        public static boolean checkNum(Integer num){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(num % 2 == 0){
               return true;
           }
           return false;
        }
}
