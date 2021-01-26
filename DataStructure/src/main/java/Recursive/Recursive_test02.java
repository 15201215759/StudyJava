package Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursive_test02 {
    public static int anInt;
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a number");
        int anInt = getInt();
        int factoral = factoral(anInt);
        System.out.println(factoral);
    }

    public static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        return s;
    }
    public static int getInt() throws IOException {
        String string = getString();
        return Integer.parseInt(string);
    }
    public static int factoral(int n){
        if (n ==1){
            return 1;
        } else {
            return (n*factoral(n-1));
        }

    }

}
