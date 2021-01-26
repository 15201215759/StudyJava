package sort;

import java.util.Arrays;

public class InsertSort1 {
    public static void main(String[] args) {
        int[] arr = {91,5,3,2,7,1,6,8};
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            int temp=arr[i];
            int index=i;
            while (index>0&&arr[index-1]>temp){
                arr[index]=arr[index-1];
                index--;
            }
            arr[index]=temp;
        }
        System.out.println("dca".compareTo("dc")); ;
        System.out.println(Arrays.toString(arr));
    }
}
