package com.XuanLi.Thread;
//使用匿名内部类
//什么是匿名内部类
public class TestThread03  {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("子线程 i=" + i);
                }
            }
        });
        thread.start();
        for (int i = 0; i < 50; i++) {
            System.out.println("主线程 i="+i);
        }
    }
}
