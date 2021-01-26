package com.Xuanli.arr;
//手写有序数组

public class orderarr {

    private  long[] arr;
    //表示有效数组的长度
    private int elements;

    //无参构造 默认长度为50
    
   public orderarr(){
       arr = new long[50];
   }
   //有参构造  长度为传入参数
   public orderarr(int minindex){
       arr= new long[minindex];
   }
   //添加数据
    public void insert(long value){
      //判断插入的值的大小确定索引的位置
       int i;
        for (i = 0; i <elements ; i++) {
            if (arr[i]>value){
                break;
            }
        }
        //把大于该值的位置的数值后移
        for (int j = elements; j > i; j--) {
            arr[j]=arr[j-1];
        }
        //赋值 更新数组的有效长度
       arr[i]=value;
        elements++;
    }

   //显示数据
   public void display(){
       System.out.println("[");
       for (int i = 0; i < elements; i++) {
           System.out.print(arr[i]+" ");
       }
       System.out.println("]");
   }
   //查找数据  二分查找
    public long searchtwo(long value){
       int start=0;
       int end=elements;
       int mind=0;
       while (true){
           mind=(end+start)/2;
           if (arr[mind]==value){
               return mind;
           }else if (start>end){
               return -1;

           }else {
               if (arr[mind]>value){
                   end=mind-1;
               }else {
                   start=mind+1;
               }
           }
       }

    }

    public int search(long value){
        int i;
        for ( i= 0;  i<elements ; i++) {
            if (arr[i] == value) {
                break;
            }
        }
        if (i == elements) {
            return -1;

        }else {
            return i;
        }

    }
    //按索引查找
    public long searchIndex(int index){
        if (index>=elements || index<0){
            throw new ArrayIndexOutOfBoundsException();
        }else {
            return arr[index];
        }
    }


    //更新数据
    public void update(int index,long value){
        if (index>=elements || index<0){
            throw new ArrayIndexOutOfBoundsException();
        }else {
            arr[index]=value;
        }
    }
//删除数据

    public  void delete(int index){
        if (index>=elements || index<0){
            throw new ArrayIndexOutOfBoundsException();
        }else {
            for (int i = index; i >elements; i++) {
                    arr[i]=arr[i+1];
            }
            elements--;
        }

    }
}
