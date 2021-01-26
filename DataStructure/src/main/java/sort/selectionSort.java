package sort;

import java.util.Arrays;

/**
 * 选择排序：依次比较选择最小的记录下拉，全部比较完交换
 */
public class selectionSort {
  static   int[] arr={4,5,2,7,9,1,4,3,8};
    public static void main(String[] args) {
        int[] arr={4,5,2,7,9,1,4,3,8};
        System.out.println(Arrays.toString(arr));
        int tempvalue=0;
        int tempindex=0;
        for (int i = 0; i <arr.length-1; i++) {
            tempindex=i;
            for (int j = i+1; j <= arr.length-1; j++) {
                if (arr[tempindex] > arr[j]) {
                    tempindex=j;
                }
            }
            tempvalue=arr[tempindex];
            arr[tempindex]=arr[i];
            arr[i]=tempvalue;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("----------------");

     // SelectSort();
    }


    static void SelectSort()
    {

        int begin = 0;
        int end = arr.length - 1;
        int max = 0;
        int min = 0;
        while(begin < end)
        {
            max = begin;
            min = begin;
            for(int i = begin;i <= end;i++)
            {
                if(arr[i]>=arr[max])  //有相同元素时，最大的要找位置相对最后的一个最大的
                {
                    max = i;
                }
                if(arr[i]<arr[min])  //最小的要找位置相对最前的一个最小的，这样可以使选择排序算法稳定
                {
                    min = i;
                }
            }
            if(max == begin && min == end)
            {
                swap(arr[max],arr[end]);
                continue;
            }

            if(max == begin)
            {
                swap(arr[max],arr[end]);
                swap(arr[min],arr[begin]);
                continue;
            }

            if(min == end)
            {
                swap(arr[min],arr[begin]);
                swap(arr[max],arr[end]);
                continue;
            }
            swap(arr[min],arr[begin]);
            swap(arr[max],arr[end]);
            begin++;
            end--;
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void swap(int one,int two){
        int temp=arr[one];
        arr[one]=arr[two];
        arr[two]=temp;
    }
}
