package Recursive;

/**
 * 归并排序
 */
public class MergeSortApp {
    public static void main(String[] args) {
        DArray dArray = new DArray(100);
        dArray.insert(54);
        dArray.insert(41);
        dArray.insert(7);
        dArray.insert(45);
        dArray.insert(99);
        dArray.insert(1);
        dArray.insert(94);
        dArray.insert(34);
        dArray.insert(337);
        dArray.insert(83);
        dArray.insert(3);
        dArray.insert(15);
        dArray.desplay();
        dArray.mergSort();
        dArray.desplay();
    }
}

/**
 * 数组类
 */
class DArray{
    private long[] theArray;//成员变量数组
    private int nElems;//数组的数量

    /**
     * 构造方法
     * @param size
     */
    public DArray(int size){
       theArray=new long[size];
       nElems=0;
    }

    /**
     * 数组插入数据的方法
     * @param value
     */
    public void insert(long value){
        theArray[nElems]=value;
        nElems++;
    }

    /**
     * 显示数组数据的方法
     */
    public void desplay(){
        for (int i = 0; i <nElems ; i++) {
            System.out.print(theArray[i]+" ");
        }
        System.out.println();
    }

    /**
     * 数组的排序方法
     */
    public void mergSort(){
        long[] workSapce = new long[nElems];
        //调用排序的方法
        recMergSort(workSapce,0,nElems-1);
    }

    /**
     * 排序的方法，
     * @param workspace  新数组，用于操作
     * @param lowerbound  排序的起始位置
     * @param upperbound  排序的结束位置
     */
    public void recMergSort(long[] workspace,int lowerbound,int upperbound){
        if (lowerbound == upperbound) {
            return;
        }else{
            int mid=(lowerbound+upperbound)/2;
            recMergSort(workspace,lowerbound,mid);//排序左边的部分
            recMergSort(workspace,mid+1,upperbound);//排序右边的部分
            merge (workspace,lowerbound,mid+1,upperbound);//合并的方法
        }
    }

    /**
     * 合并的方法
     * @param workspace  新的数组 用于操作
     * @param lowPtr     合并的左边起始位置
     * @param highPtr    合并的右边起始位置
     * @param upperbound 合并的右边结束位置
     */
    private void merge(long[] workspace, int lowPtr, int highPtr, int upperbound) {
        int j=0;//用于判断数组合并到那个位置
        int lowerbound=lowPtr;//低位的起始位置
        int mid=highPtr-1;//中间的位置
        int n=upperbound-lowerbound+1;//要归并的数量
        while (lowPtr<=mid&&highPtr<=upperbound){  //判断比较的范围是否在范围内
            if (theArray[lowPtr]<theArray[highPtr]){//如果左边的低位小于右边的低位
                workspace[j++]=theArray[lowPtr++];//则把左边的数组值赋值到新的数组中并位置判断值增加1
            }else {
                workspace[j++]=theArray[highPtr++];//否则把右边边的数组值赋值到新的数组中并位置判断值增加1
            }
        }
        while (lowPtr<=mid){//如果左边的值还小于中间值，证明右边的值已经全部赋值到新数组中，左边有剩余
            workspace[j++]=theArray[lowPtr++];
        }
        while (highPtr<=upperbound){//如果右边的值还小于中间值，证明左边的值已经全部赋值到新数组中，右边有剩余
            workspace[j++]=theArray[highPtr++];
        }
        //把数组赋值到原数组
        for (int i = 0; i < n; i++) {
            theArray[lowerbound+i]=workspace[i];
        }
    }
}