package StackT;
//用栈的特点反转字符串
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackR {
    private char [] stackarr;
    private int top;
    private int maxsize;
    private String vv;
    public StackR(String s){
        top=-1;
        maxsize=s.length();
        this.vv=s;
        stackarr=new char[maxsize];
    }
    public void pushString(String value){
        for (int i = 0; i <value.length(); i++) {
            stackarr[++top]=value.charAt(i);
        }
    }
    public void push(char value){
        stackarr[++top]=value;
    }
    public char pop(){
        return stackarr[top--];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==maxsize-1;
    }
    //反转的方法
    public String resore(){
        String result="";
         if (top==-1){
             return result;
         }else {
             while (!isEmpty()){
                 char s=pop();
                 result+=s;
             }
             return result;
         }

    }

    public static void main(String[] args) throws IOException {
        System.out.println("请控制台输入");
        System.out.flush();
        String sysint = sysint();
        //创建栈对象
        StackR stackR = new StackR(sysint);
        //把字符串放入到栈中
       stackR.pushString(sysint);
        //调用反转的方法
       String resore = stackR.resore();
       System.out.println(resore);
    }
    //调用控制台输入通过输入流获取输入的字符串
    //用缓冲流获取字符串
    //返回
    public static String sysint() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
       return br.readLine();
    }
}
