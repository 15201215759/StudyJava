package Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursive_test01 {
    public static int thenumber;
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a number");
        thenumber=getInt();//基值情况（终止条件）
        int triangle = triangle(thenumber);
        System.out.println(triangle);
    }
    public static int triangle(int i){
        if (i==1){
            return 1;
        }else {
            return (i+triangle(i-1));
        }
    }
    public static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        return s;
    }
    public static int getInt() throws IOException {
        String string = getString();
        int i = Integer.parseInt(string);
        return i;
    }
}
