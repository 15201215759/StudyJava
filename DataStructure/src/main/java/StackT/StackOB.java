package StackT;
//用数据结构实现一个栈
public class StackOB {
    private int[] Stackarr;//用数据实现栈
    private int maxsize;//栈中最大存储的个数
    private int top;//栈数据的定位，栈帧

    //构造方法 创建栈对象
    public StackOB(int maxsize){
        top=-1;
        this.maxsize=maxsize;
        Stackarr = new int[maxsize];
    }
    //创建一个push的方法
    public void push(int value){
       // System.out.println(top);
       // System.out.println(value);
        if (top >= maxsize-1) {
           System.out.println("rang-out");
       }else {
            Stackarr[++top]=value;
        }
    }
    //创建一个pop的方法
    public int pop()  {
        if (top <= -1) {
            throw new ArrayIndexOutOfBoundsException();
        }else {
            return Stackarr[top--];
        }

    }
    //创建一个查看的方法
    public int lookup(){
        return Stackarr[top];
    }
    //创建一个判断是否为空的方法
    public boolean isEmpty(){
        return top==-1;
    }
    //创建一个是否为满的方法
    public boolean isFull(){
        return top==maxsize-1;
    }
}

class teststack{
    public static void main(String[] args) {

        StackOB stackOB = new StackOB(10);
        stackOB.push(1);
        stackOB.push(2);
        stackOB.push(3);
        stackOB.push(4);
        stackOB.push(5);
        stackOB.push(6);
        stackOB.push(7);
        stackOB.push(8);
        stackOB.push(9);
        stackOB.push(10);
       // stackOB.push(1);
        while (!stackOB.isEmpty()){
            System.out.println("显示"+stackOB.lookup());
            System.out.println("pop"+stackOB.pop());
        }
    }
}
