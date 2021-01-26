package sort;

import java.util.Arrays;

/**
 * 冒泡排序：两两比较，把最大的排到最后，在从头两两比较
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {91,5,3,2,7,1,6,8};
        int temp=0;
        System.out.println(Arrays.toString(arr));
        //外循环  把最大的移动到最后，不再循环已经排序的最大的
        for (int j = arr.length-1; j >0 ; j--) {
            //内循环
            for (int i = 0; i < j; i++) {
                if(arr[i]>arr[i+1]){
                    temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
