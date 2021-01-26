package com.XuanLi.Thread;

public class TestThread06 {
    public static void main(String[] args) {
     final  Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T1111 i" + i);
                }
            }
        });
        t1.start();

       final Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    t1.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T2222 i" + i);
                }
            }
        });
        t2.start();
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                try {
                    t2.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T3333 i" + i);
                }
            }
        });
        t3.start();
    }
}
