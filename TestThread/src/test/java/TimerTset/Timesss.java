package TimerTset;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//如果觉得不好用 可以使用Quartz这个框架
public class Timesss {
    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    },new Date(System.currentTimeMillis()+1000),1000);
}
}
