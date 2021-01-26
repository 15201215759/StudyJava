package sort;

public class ShellSort {
    public static void main(String[] args) {
        ShellArr shellArr = new ShellArr(100);
        for (int i = 0; i < 20; i++) {
            double v = Math.random() * 99;
            int a=(int)v;
            shellArr.insert(a);
        }
        shellArr.desplay();
        System.out.println("调用希尔排序后");
        shellArr.shellSort();
        shellArr.desplay();
    }
}

class ShellArr{
    private int maxSize;
    private int[] arr;
    private int nElems;

    public ShellArr(int size){
        maxSize=size;
        arr = new int[size];
        nElems=0;
    }

    public void insert(int value){
        arr[nElems]=value;
        nElems++;
    }

    public void desplay(){
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void shellSort(){
        int inner,outer;
        int temp;
        int h=1;//最小间隔数
        //求最大间隔
        while (h<=nElems/3){
            h=h*3+1;//1,4,13,40....
        }
        //根据得出的最大间隔进行分组插入排序，反转公式缩小间隔
        while (h>0){
           //进行分组插入排序
            for (outer=h;outer<nElems;outer++){
                temp=arr[outer];
                inner=outer;
                while(inner>h-1&& temp<=arr[inner-h]){
                    arr[inner]=arr[inner-h];
                    inner=inner-h;
                }
                arr[inner]=temp;
            }
            h=(h-1)/3;//用于缩小间隔
        }
    }
}
