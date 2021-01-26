package com.XuanLi.Thread;

import java.util.concurrent.*;


public class TestThreadCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
      //1.创建线程
        ExecutorService es = Executors.newFixedThreadPool(2);
        CallTest call1 = new CallTest("c1",200);
        CallTest call2 = new CallTest("c2",100);

        //2.获取对象
        Future<Integer> result1 = es.submit(call1);
        Future<Integer> result2 = es.submit(call2);

        //终端线程内的while循环
        Thread.sleep(1000);
        call1.setFlag(false);
        call2.setFlag(false);
        long time1 = call1.getTime();
        long time2 = call2.getTime();
        System.out.println(time1);
        System.out.println(time2);


        int i1 = result1.get();
        int i2 = result2.get();
        //3.测试输出
        System.out.println("c1----"+i1);
        System.out.println("c2----"+i2);
        //4.停止线程服务
        es.shutdownNow();

    }
}

class CallTest implements Callable<Integer>{
    private String name;
    private long time;
    private boolean flag=true;
    private Integer step=0;

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public CallTest() {
    }

    public CallTest(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public Integer call() throws Exception {
       while(flag){
           Thread.sleep(time);
           step++;
           System.out.println(name+"--------"+step);
       }
        return step;

    }
}
