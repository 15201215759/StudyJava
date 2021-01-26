package sort;

import java.util.Arrays;

/**
 * 插入排序:从第二位开始  取出为临时变量，与之前的比较，如果前面的大
 * 就依次往后移动，把这个临时的比较值插入到比前面的大 ，比后面的小的位置
 *
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {91,5,3,2,7,1,6,8};
        System.out.println(Arrays.toString(arr));
        int temp=0;
        for (int i = 1; i <arr.length ; i++) {
            int index=i;
            temp =arr[i];
            while (index>0){
                if (arr[index-1]>temp){
                    arr[index]=arr[index-1];
                    index--;
                }else {
                    break;
                }

            }
            arr[index]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
