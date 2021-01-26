package sort;
/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        ArrSrot arrSrot = new ArrSrot(100);
        for (int i = 0; i < 20; i++) {
            int i1 = (int) (Math.random() * 99);
            arrSrot.insert(i1);
        }
        arrSrot.desplay();
        System.out.println("快速排序之后的数组");
        arrSrot.quickSort();
        arrSrot.desplay();
    }
}

class ArrSrot{
    private int maxSize;
    private int [] Array;
    private int nElems;

    public ArrSrot(int size){
        maxSize=size;
        Array=new int[maxSize];
        nElems=0;
    }
    public void insert(int value){
        Array[nElems]=value;
        nElems++;
    }
    public void desplay(){
        for (int i = 0; i <nElems ; i++) {
            System.out.print(
                    Array[i]+" "
            );

        }
        System.out.println();
    }

    public void quickSort(){
        reQuickSort(0,nElems-1);
    }
    /**
     * 用递归和划分技术进行快速排序
     * @param left
     * @param right
     */
    public void reQuickSort(int left,int right){
        if (left-right>=0) {//递归的终止条件，判断左右的标志位置到达
            return;
        }else{
            int p=Array[right];
            int partition = partition(left, right,p);
            reQuickSort(left,partition-1);//左边递归 原划分值已经是中间值，不要在使用
            reQuickSort(partition+1,right);//右边递归
        }
    }

    /**
     * 划分交换的方法
     * @param left
     * @param right
     * @param p
     * @return
     */
    private int partition(int left, int right,int p) {
        int leftPrt=left-1;
        int rightPrt=right;
        while (true){
            while (Array[++leftPrt]<p);//判断左边的是否大于界限值
            while (rightPrt>0 && Array[--rightPrt]>p);//判断右边的是否大于界限值
            if (leftPrt>=rightPrt){//判断是否结束
                break ;
            }else {
                swap(leftPrt,rightPrt);//左右边数据交换
            }
        }
        swap(leftPrt,right);//避免选择的界限值不合理   做一次交换****不再使用以前的划分值
        return leftPrt;
    }

    /**
     * 交换的方法
     * @param leftPrt
     * @param rightPrt
     */
    private void swap(int leftPrt, int rightPrt) {
        int temp=Array[leftPrt];
        Array[leftPrt]=Array[rightPrt];
        Array[rightPrt]=temp;
    }
}
