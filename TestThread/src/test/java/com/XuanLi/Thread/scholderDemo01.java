package com.XuanLi.Thread;

public class scholderDemo01 {
    public static void main(String[] args) {
        Object o1=new Object();
        Object o2=new Object();
        tttt tttt = new tttt(o1,o2);
        Thread t1 = new Thread(tttt);
        tttt1 tttt2 = new tttt1(o1,o2);
        Thread t2 = new Thread(tttt2);
        t2.start();
    }
}


class tttt implements Runnable{
    Object o1;
    Object o2;

    public tttt(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    public void run() {
    while(true){
        T1();
    }
    }
    public void T1(){
        synchronized (o1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){
                System.out.println("sssss1");
            }
        }
    }
}


class tttt1 implements Runnable{
    Object o1;
    Object o2;

    public tttt1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    public void run() {
        while(true){
            T1();
        }
    }
    public void T1(){
        synchronized (o2){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println("sssss2");
            }
        }
    }
}