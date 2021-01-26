package com.XuanLi.Thread;
class ttThread implements Runnable{

    public void run() {
        for (int i = 0; i <20 ; i++) {

            System.out.println(Thread.currentThread().getId()+"----"+Thread.currentThread().getName()+"----"+i);
//            if (i == 5) {
//                Thread.currentThread().stop();
//            }
        }

    }
}

public class TestThread04 {


    public static void main(String[] args) {
        ttThread ttThread = new ttThread();
        Thread zixiancheng = new Thread(ttThread, "zixiancheng");
        zixiancheng.start();
        for (int i = 0; i <20 ; i++) {
            System.out.println(Thread.currentThread().getId()+"----"+Thread.currentThread().getName()+"----"+i);
        }
    }
}
