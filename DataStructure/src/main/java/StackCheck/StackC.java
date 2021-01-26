package StackCheck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//创建一个存储字符串的栈
public class StackC {
    private char[] chararr;
    private int maxsize;
    private int top;
    private String checkvalue;


    public  StackC(String value){
        top=-1;
        maxsize=value.length();
        chararr = new char[maxsize];
        checkvalue=value;
    }
    public void push(char value){
        chararr[++top]=value;
    }
    public char pop(){
        return chararr[top--];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==maxsize-1;
    }

}

class mainStackCheck{


    public static void check(StackC s, String value){
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            switch (c){
                case '{':
                case '[':
                case '(':
                    s.push(c);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!s.isEmpty()) {
                        if (c=='}'&&s.pop()!='{'||c==']'&&s.pop()!='['||c==')'&&s.pop()!='('){
                            System.out.println("Error");
                        }
                    }else {
                        System.out.println("Error");
                    }
                    break;
                default:
                        break;
            }
        }
    if (!s.isEmpty()){
        System.out.println("缺少匹配的括号");
    }else {
        System.out.println("ok" );
    }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Please input");
        String sysint = sysint();
        StackC stackC = new StackC(sysint);
        mainStackCheck.check(stackC,sysint);

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
