package com.XuanLi.Thread;
//实现Runable 接口  重写run的方法
public class TestThread02Runable implements Runnable {
    public void run() {
        for (int i = 0; i <50 ; i++) {
            System.out.println("子线程 i="+i);
        }
    }
    public static void main(String[] args) {
        //创建多线程实现类
        TestThread02Runable t1 = new TestThread02Runable();
       //创建线程类Thread
        Thread thread = new Thread(t1);
        //调用Start方法
        thread.start();
        for (int i = 0; i <50 ; i++) {
            System.out.println("主线程 i="+i);
        }
    }
}
