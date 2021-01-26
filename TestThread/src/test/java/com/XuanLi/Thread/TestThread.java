package com.XuanLi.Thread;

/**
 *
 */
public class TestThread {
    /**
     * 实现多线程的几种方式
     * 1.使用继承Therad类的方式
     * 2.使用实现runlabe接口的方式
     * 3.使用匿名内部类
     * 4.callable
     * 5.使用线程池创建线程
     */
}

class CreateThreadDemo01 extends Thread{
   //run方法是线程需要执行的任务或者执行的代码

    @Override
    public void run() {
        for (int i = 0; i <30 ; i++) {
            System.out.println("run,i= "+i);
           // System.out.println(this.getThreadGroup().getName());
        }
    }

    public static void main(String[] args) {
        //1.如何使用这个线程类
        CreateThreadDemo01 createThreadDemo01 = new CreateThreadDemo01();
        //2.启动线程是调用start方法
        createThreadDemo01.start();
        for (int i = 0; i <30 ; i++) {
            System.out.println("main  i="+i);

        }
    }
}

