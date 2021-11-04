package com.atguigu.git.test;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestDemo {


    @Test
    public void test4(){
        int i = 1;
        i = i++;//
        int j = i++;
        int k = i + ++i * i++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }

    @Test
    public void test3(){
        List<Student> list = StudentData.getList();
        Double aDouble = list.stream().map(Student::getScore).reduce(Double::sum).orElse(0.0);
        System.out.println(aDouble);
    }

    @Test
    public void test6(){
        List<Student> list = StudentData.getList();
        Double reduce = list.stream().map(Student::getScore).reduce(0.0, (u, t) -> u + t);
        Double reduce1 = list.stream().map(Student::getScore).reduce(Double::sum).get();
        System.out.println(reduce + "==" + reduce1);

    }

    @Test
    public void test7(){
        List<Student> list = StudentData.getList();
        Double reduce = list.stream().map(Student::getScore).reduce(Double.MAX_VALUE, Double::min);
        DoubleSummaryStatistics doubleSummaryStatistics = list.stream().map(Student::getScore).mapToDouble(t -> t).summaryStatistics();
        double max = doubleSummaryStatistics.getMax();
        double average = doubleSummaryStatistics.getAverage();
        double sum = doubleSummaryStatistics.getSum();
        System.out.println(max);
        System.out.println(average);
        System.out.println(sum);
    }

    @Test
    public void test8(){
//        List<Student> list = StudentData.getList();
        List<Student> list = new ArrayList();
        Double aDouble = list.stream().map(Student::getScore).max(Double::compare).orElse(10.0);
        Double aDouble1 = list.stream().map(Student::getScore).min(Double::compare).orElse(0.0);
        System.out.println(aDouble);
        System.out.println(aDouble1);
    }

    @Test
    public void test9() {
//        List<Student> list = StudentData.getList();
        List<Student> list = new ArrayList();

        Double collect = list.stream().collect(Collectors.averagingDouble(Student::getScore));

        Student student = list.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Student::getScore))).orElse(new Student());

        System.out.println(student.getScore());
    }

    @Test
    public void test10() {
        List<Student> list = StudentData.getList();
        Double reduce = list.stream().map(Student::getScore).reduce(0.0, Double::sum);
        Double collect = list.stream().collect(Collectors.reducing(0.0, Student::getScore, Double::sum));
        System.out.println(collect);
        System.out.println(reduce);
    }

    @Test
    public void test11() {
        List<Student> list = StudentData.getList();
        Map<Integer, List<Student>> collect = list.stream().collect(Collectors.groupingBy(Student::getGrade));
        Iterator<Map.Entry<Integer, List<Student>>> iterator = collect.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, List<Student>> next = iterator.next();
            next.getValue().stream().forEach(System.out::println);
            System.out.println("=================");

        }
    }

        @Test
    public void test5(){
        List<Student> list = StudentData.getList();
        list.stream().sorted((t,u)->{
            if((int)t.getScore()-(int) u.getScore() > 0) {
                return (int)t.getScore()-(int) u.getScore();
            }else if((int)t.getScore()-(int) u.getScore() == 0) {
                return t.getGrade()- u.getGrade();
            }
            return (int)t.getScore()-(int) u.getScore();
        }).forEach(t->{
            System.out.println(t);
        });



    }



    @Test
    public void test2(){
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("开始");
            }
        };
        runnable.run();

    }

    @Test
    public void test1(){

    }

    public List<String> fiterList(List<String> list, Predicate<String> predicate){
        Double.sum(12.0,13.0);
        return null;
    }
}
