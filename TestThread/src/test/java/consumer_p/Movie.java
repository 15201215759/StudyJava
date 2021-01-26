package consumer_p;

/**
 * 一个场景 共同的资源
 */
public class Movie {
    private String pic;

    private Boolean Flag=true;

    public synchronized void play(String pic){
        //判断是否要生产
        if (!Flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //生产消息
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.pic=pic;
        //通知消费者开始消费
        this.notify();
        //停止生产者
        Flag=false;

    }

    public synchronized void watch(){
        //停止消费者
        if (Flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //开始消费
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(pic);
        //通知生产者开始生产
        this.notifyAll();
        //停止消费者
        Flag=true;
    }

}


