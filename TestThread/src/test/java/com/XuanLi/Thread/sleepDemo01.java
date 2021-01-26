package com.XuanLi.Thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1.倒数10
 * 2.倒计时
 */
public class sleepDemo01 {
    public static void main(String[] args) throws InterruptedException {
//        int num=10;
//        while (true){
//            num--;
//            System.out.println(num);
//        Thread.sleep(1000);
//            if (num <= 0) {
//                System.out.println("倒计时结束");
//                break;
//            }
//        }
        /**
         * 倒计时
         */
        //获取当前时间的后十秒的时间，作为结束时间
        Date endtime = new Date(System.currentTimeMillis() + 10 * 1000);
        long end = endtime.getTime();
        //
        while (true){
            //输出
            System.out.println(new SimpleDateFormat("mm:ss").format(endtime));
            //构建下一秒时间
            endtime= new Date(endtime.getTime() - 1000);
            //等待一秒
            Thread.sleep(1000);
            //判断十秒以内继续，否则退出
            if (end-10000>endtime.getTime()){
                break;
            }
        }
    }
}
