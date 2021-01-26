package Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursive_test06 {
    static int number;
    static int answer;
    static StackXX stack;
    public static void main(String[] args) throws  IOException{
        System.out.println("Enter a Number");
        number = getInt();
        theAnswer();
        System.out.println("The Answer Is " + answer);

    }
    public static void theAnswer(){
        stack = new StackXX(10000);
        answer=0;
        while (number>0){
            stack.push(number);
            number--;
        }
        while (!stack.isEmpty()){
            answer+=stack.pop();
        }
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

class StackXX{
    public int maxSize;
    public int[] arr;
    public int top;
    public StackXX(int size){
        maxSize=size;
        arr=new int[maxSize];
        top=-1;
    }
    public void push(int value){
        arr[++top]=value;
    }
    public int pop(){
        return arr[top--];
    }
    public int peek(){
        return arr[top];
    }
    public boolean isEmpty(){
        return top==-1;
    }
}

