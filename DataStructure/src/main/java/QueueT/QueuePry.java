package QueueT;
/**
 * 优先级队列 排序的队列
 */
public class QueuePry {
    private int[] queuearr;
    private int items;
    private int maxsize;
    public QueuePry(int s){
        items=0;
        maxsize=s;
       queuearr= new int[maxsize];
    }
    /**
     * 插入的方法
     * @param value 要插入的值
     */
    public void insert(int value){
        int j;
        if (items==0){
            queuearr[items++]=value;
        }else {
            for (j = items-1; j >=0; j--) {
                if (value>queuearr[j]){
                    queuearr[j+1]=queuearr[j];
                }else {
                    break;
                }
            }
            queuearr[j+1]=value;
            items++;
        }
    }

    /**
     * 删除的方法
     * @return 返回删除的值
     */
    public int remove(){
        return queuearr[--items];
    }

    /**
     * 查看的方法
     * @return  返回最小的值
     */
    public int peek(){
        return queuearr[items-1];
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return items==0;
    }

    /**
     * 判断是否是满的
     * @return
     */
    public boolean isFull(){
        return items==maxsize;
    }
}
