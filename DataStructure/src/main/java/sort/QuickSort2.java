package sort;

/**
 * 三数取中的方法确定分界值/小数据量用插入排序
 */
public class QuickSort2 {
    public static void main(String[] args) {
    ArrSrot1 arrSrot = new ArrSrot1(100);
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

class ArrSrot1{
    private int maxSize;
    private int [] Array;
    private int nElems;

    public ArrSrot1(int size){
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
        int size=right-left+1;
        //小数据项用插入排序
        if (size<10) {
            insertSort(left,right);
       // if (size<=3) {//递归的终止条件，判断左右的标志位置到达
           // manual(left,right);
        }else{
            int p=medianOf3(left,right);
            int partition = partition(left, right,p);
            reQuickSort(left,partition-1);//左边递归 原划分值已经是中间值，不要在使用
            reQuickSort(partition+1,right);//右边递归
        }
    }

    private void insertSort(int left, int right) {
        int in,out;
        int temp;
        for (out = left+1; out <=right; out++) {
            temp=Array[out];
            in=out;
            while(in>left && Array[in-1]>temp){
                Array[in]=Array[in-1];
                in--;
            }
            Array[in]=temp;
        }
    }

    private int medianOf3(int left, int right) {
       int center=(left+right)/2;
       if (Array[left]>Array[center])swap(left,center);
       if (Array[left]>Array[right])swap(left,right);
       if (Array[center]>Array[right])swap(center,right);
       swap(center,right-1);
       return Array[right-1];
    }

    /**
     * 小于等于三个数的时候不用递归，手工排序
     * @param left
     * @param right
     */
    private void manual(int left, int right) {
        int size=right-left+1;
        if (size<=1){
            return;
        }
        if (size==2){
            if (Array[left]>Array[right]){
                swap(left,right);
                return;
            }
        }else {
            if (Array[left]>Array[right-1]) swap(left,right-1);
            if (Array[left]>Array[right]) swap(left,right);
            if (Array[right-1]>Array[right]) swap(right-1,right);
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
        int leftPrt=left;
        int rightPrt=right-1;
        while (true){
            while (Array[++leftPrt]<p);//判断左边的是否大于界限值
            while (Array[--rightPrt]>p);//判断右边的是否大于界限值
            if (leftPrt>=rightPrt){//判断是否结束
                break ;
            }else {
                swap(leftPrt,rightPrt);//左右边数据交换
            }
        }
        swap(leftPrt,right-1);//避免选择的界限值不合理   做一次交换****不再使用以前的划分值
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
