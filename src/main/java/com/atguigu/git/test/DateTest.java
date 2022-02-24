package com.atguigu.git.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) throws ParseException {
        String Birth = "2022-1-9";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(Birth);

        java.sql.Date date = new java.sql.Date(parse.getTime());
        Boolean aBoolean = dateCompare(date);
        System.out.println(aBoolean);

    }


    public static Boolean dateCompare(Date time) {
        Calendar calendar = Calendar.getInstance();
        int now_y = calendar.get(Calendar.YEAR);//获得年份
        int now_m = calendar.get(Calendar.MONTH) + 1;//获得月份
        int now_d = calendar.get(Calendar.DATE);//获得月份中今天的号数
        calendar.setTime(time);
        int y = calendar.get(Calendar.YEAR);//获得年份
        int m = calendar.get(Calendar.MONTH) + 1;//获得月份
        int d = calendar.get(Calendar.DATE);//获得月份中今天的号数
        if (now_y < y || (now_y == y && now_m < m) || (now_y == y && now_m == m && now_d <= d)) {
            return false;
        } else {
            return true;
        }
    }
}
