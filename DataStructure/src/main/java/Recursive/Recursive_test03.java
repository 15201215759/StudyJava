package Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 变位字
 */
public class Recursive_test03 {
    static int size;//
    static int count;//
    static char[] arrChar=new char[100];//
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a word:");
        String input=getString();
        size=input.length();
        count=0;
        for (int i = 0; i <size ; i++) {
            arrChar[i]=input.charAt(i);
        }
        doAnagram(size);
    }

    /**
     * 变位颠倒
     * @param newSize
     */
    public static void doAnagram(int newSize){
        if(newSize==1){
            return;
        }
        for (int i = 0; i <newSize ; i++) {
            doAnagram(newSize-1);
            if (newSize==2){
                displayWord();
            }
            rotate(newSize);
        }
    }

    /**
     * 调换的方法
     * @param newSize
     */
    public static void rotate(int newSize) {
        int j;
        int position=size-newSize;
        char temp=arrChar[position];
        for (j =position+1; j <size ; j++) {
            arrChar[j-1]=arrChar[j];
        }
        arrChar[j-1]=temp;
    }

    public static void displayWord() {
        if (count<99){
            System.out.print(" ");
        }
        if (count<9){
            System.out.print("  ");
        }
        System.out.print(++count+" ");
        for (int j=0;j<size;j++){
            System.out.print(arrChar[j]);
        }
        System.out.print("  ");
        System.out.flush();
        if (count%6==0){
            System.out.println();
        }
    }

    public static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }
}
