package QueueT;
//用java代码实现队列，特点先进先出，访问受限，不能访问中间的元素
public class QueueClass {
    private int[] queuearr;
    private int maxsize;
    private int items;//总个数
    private int fornt;//删除的指针
    private int rear;//插入的指针

    public QueueClass(int s){
        maxsize=s;
        rear=-1;
        fornt=0;
        items=0;
      queuearr = new int[maxsize];
    }
    //插入数据的方法
    public void insert(int value){
        if (rear==maxsize-1){rear=-1;}
        queuearr[++rear]=value;
        items++;
    }
    //删除的方法
    public int remove(){
        if (fornt==maxsize){fornt=0;}
        int temp=queuearr[fornt++];
        items--;
        return temp;
    }
    //查看的方法
    public int peek (){
        return queuearr[fornt];
    }
    //是否为空
    public boolean isEmpty(){
        return items==0;
    }
    //是否存满
    public boolean isFull(){
        return items==maxsize;
    }
}

class Queueapp{
    public static void main(String[] args) {
        QueueClass queueClass = new QueueClass(5);
        queueClass.insert(10);
        queueClass.insert(20);
        queueClass.insert(30);
        queueClass.insert(40);
        System.out.println("remove"+queueClass.remove());
        System.out.println("remove"+queueClass.remove());
        System.out.println("remove"+queueClass.remove());
        System.out.println("peek"+queueClass.peek());
        System.out.println(queueClass.isEmpty()+"--------"+queueClass.isFull());
        System.out.println("--------------------------------------------");
        System.out.println("remove"+queueClass.remove());
        System.out.println("peek"+queueClass.peek());
        System.out.println(queueClass.isEmpty()+"--------"+queueClass.isFull());
    }
}
