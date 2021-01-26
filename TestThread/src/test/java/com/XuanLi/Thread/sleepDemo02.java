package com.XuanLi.Thread;

/**
 * 单例设计模式
 * 确保一个类只有一个对象
 * 1.懒汉式
 *      a.构造器私有化，避免外部创建对象
 *      b.声明一个私有的静态的变量
 *      c.创建一个对外共有的静态的获取变量的方法，没有该对象则创建对象
 */
public  class sleepDemo02 {
}

class Jvm{
    //构造器私有化，避免外部创建对象
    private Jvm(){
    }
    //声明一个私有的静态的变量
    private static Jvm instace=null;
    //创建一个对外共有的静态的获取变量的方法，没有该对象则创建对象
    public static Jvm getInstace(){
        if (instace == null) {//提到效率
            synchronized(Jvm.class){
                if (instace == null) {//安全
                    instace = new Jvm();
                }
            };
        }
        return instace;
    }

}

/**
 * 2.饿汉式
 *      a.构造器私有化，避免外部创建对象
 *      b.声明一个私有的静态的变量,创建该对象
 *      c.创建一个对外共有的静态的获取变量的方法
 */
class Jvm2{
    //构造器私有化，避免外部创建对象
    private Jvm2(){

    }
    //声明一个私有的静态的变量,创建该对象
    private static Jvm2 instance=new Jvm2();
    //创建一个对外共有的静态的获取变量的方法
    public static Jvm2 getInstance(){
        return instance;
    }
}

//提高效率的方法
class Jvm3{
    //构造器私有化，避免外部创建对象
    private Jvm3(){
    }
    //声明一个私有的静态的变量,创建该对象
    //用一个内部类  类在使用的时候创建
    //延缓加载时机
    private static class JvmHolder{
        private static Jvm3 instance=new Jvm3();
    }
    //创建一个对外共有的静态的获取变量的方法
    public static Jvm3 getInstance(){

        return JvmHolder.instance;
    }
}