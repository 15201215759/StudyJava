package com.XuanLi.Thread;
public class TestThread05 {
    public static void main(String[] args) throws InterruptedException {
        Thread ccc = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        }, "ccc");
       ccc.setDaemon(true);//设置为守护线程，与主线程一起销毁

        ccc.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(300);
            String name = Thread.currentThread().getName();
            System.out.println(name+i);
        }
        System.out.println("主线程结束！");
    }
}
