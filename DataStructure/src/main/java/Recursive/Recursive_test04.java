package Recursive;
/**
 * 递归二分查找-分治查找算法
 */
public class Recursive_test04 {
    public static void main(String[] args) {
        ordArray ordArray = new ordArray(10);
        ordArray.insert(90);
        ordArray.insert(10);
        ordArray.insert(60);
        ordArray.insert(20);
        ordArray.insert(40);
        ordArray.insert(11);
        ordArray.insert(88);
        ordArray.desplay();
        long l = ordArray.find(88);
        System.out.println(l);

    }
}

/**
 * 有序数组类
 */
class ordArray{
    private long[] a;
    private int nElems;

    public ordArray(int max){
        a=new long[max];
        nElems=0;
    }
    public int size(){
        return nElems;
    }

    /**
     * 查找的方法，调用递归的方法
     * @param searchKey
     * @return
     */
    public long find(long searchKey){
        return recFind(searchKey,0,nElems-1);
    }

    /**
     * 二分查找
     * @param searchKey
     * @param lowerBound
     * @param upperBound
     * @return
     */
    private int recFind(long searchKey,int lowerBound,int upperBound){
        int curIn;
        curIn=(lowerBound+upperBound)/2;
        if (a[curIn]==searchKey){
            return curIn;
        }else if (lowerBound>upperBound){
            return nElems;
        }else {
            if (a[curIn]<searchKey){//查找数据大于中间，就往右边找
                return recFind(searchKey,curIn+1,upperBound);//递归
            }else {//查找数据大于中间，就往左边找
                return recFind(searchKey,lowerBound,curIn-1);//递归
            }
        }
    }

    /**
     * 插入数据的方法
     * @param value
     */
    public void insert(long value){
        int j;
        for (j=0;j<nElems;j++){
            if (a[j]>value){
                break;
            }
        }
        for (int k=nElems;k>j;k--){
            a[k]=a[k-1];
        }
        a[j]=value;
        nElems++;
    }
    public void desplay(){
        for (int i = 0; i<nElems; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
