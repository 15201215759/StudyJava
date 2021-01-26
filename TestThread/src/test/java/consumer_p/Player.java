package consumer_p;

/**
 * 相当于生产者
 */
public class Player implements Runnable {
    private Movie m;

    public Player(Movie m) {
        this.m = m;
    }

    public void run() {
        for (int i = 0; i <20 ; i++) {
            String s=i+"";
            if (0==i%2){
                m.play("play1111111111111-----------"+s);
            }else {
                m.play("play2222222222222-----------"+s);
            }
        }
    }
}
