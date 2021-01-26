package Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 用栈的方式消除递归，用参数类的方式switch语句的方式
 */
public class Recursive_test05 {
    static int number;
    static int answer;
    static StackX stack;
    static int codePart;
    static Params thParams;
    public static void main(String[] args) throws IOException{
        System.out.println("Enter a Number");
        number=getInt();
        recTriangle();
        System.out.println("The Answer is "+ answer);
    }

    public static void recTriangle(){
       stack=new StackX(100);
       codePart=1;//开始计算三角函数
        while (step()==false){//返回true 计算结束
            step();
        }
    }

    public static boolean step(){
        switch (codePart){
            case 1://开始计算三角函数
                thParams=new Params(number,6);//number是要计算的数值，6是标志为代表最底层，也是最高列
                stack.push(thParams);
                codePart=2;//读取下一列的数值
                break;
            case 2://读取下一列的数值
                if (stack.peek().n==1) {//判断当前栈中的数据是不是最后一个1
                    answer=1;//如果是1 那么说明数据已经全部放到栈中，开始求三角函数的和
                    codePart=5;//从栈取出数据，进行数据累加
                }else {
                    codePart=3;//把数值放到栈中
                }
                break;
            case 3://继续在栈中添加数据
                thParams = new Params((thParams.n - 1), 4);
                stack.push(thParams);
                codePart=2;//读取下一列的数值
                break;
            case 4://求和计算中
                thParams = stack.peek();
                answer=answer+thParams.n;
                codePart=5;//从栈取出数据，进行数据累加
                break;
            case 5:
                thParams=stack.peek();
                codePart = thParams.returnAddress;
                stack.pop();
                break;
            case 6:
                return true;

        }
        return false;
    }

    public static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(inputStreamReader);
        return bf.readLine();
    }
    public static int getInt()throws IOException{
        int i = Integer.parseInt(getString());
        return i;
    }
}

class Params{
    public int n;//数值
    public int returnAddress;//标志位
    public  Params(int nn,int ra){
        n=nn;
        returnAddress=ra;
    }
}

class StackX{
    private int maxSize;
    private Params[] parARR;
    private int top;

    public StackX(int size){
        maxSize=size;
        parARR = new Params[maxSize];
        top=-1;
    }
    public void push(Params p){
        parARR[++top]=p;
    }
    public Params pop(){
        return parARR[top--];
    }

    public Params peek(){
        return parARR[top];
    }
}


