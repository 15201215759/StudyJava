package DLink;

/**
 * 双端链表实现队列
 */
public class LinkQueue {
    public static void main(String[] args) {
        LinkQueueObjT linkQueueObjT = new LinkQueueObjT();
        linkQueueObjT.push(1);
        linkQueueObjT.push(2);
        linkQueueObjT.push(3);
        linkQueueObjT.push(4);
        linkQueueObjT.desPlay();
        linkQueueObjT.pop();
        linkQueueObjT.pop();
        linkQueueObjT.desPlay();
    }
}

/**
 * 双端链表节点类
 */
class LinkQueueNode{
    public int Data;
    public LinkQueueNode Next;

    public LinkQueueNode(int value){
        Data=value;
    }
    public void desplay(){
        System.out.print("Data----"+Data);
    }
}

/**
 * 双端链表类
 */
class LinkQueueObj{
    private LinkQueueNode first;
    private LinkQueueNode last;

    public LinkQueueObj(){
        first=null;
        last=null;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public void insertLast(int value){
        LinkQueueNode linkQueueNode = new LinkQueueNode(value);
        if (isEmpty()){
            first=linkQueueNode;
        }else {
            last.Next=linkQueueNode;
        }
        last=linkQueueNode;

    }
    public int deleteFirst(){
        LinkQueueNode temp=first;
        if (isEmpty()){
            System.out.println("null");
        }else {
            if (temp.Next==null){
              last=null;
            }
            first=first.Next;
        }
        return temp.Data;
    }

    public void desPlay(){
        LinkQueueNode current=first;
        while (current!=null){
            current.desplay();
            current=current.Next;
        }
        System.out.println();
    }
}

/**
 * 用双端链表实现队列抽象数据类型
 */
class LinkQueueObjT{
    private LinkQueueObj queue;

    public LinkQueueObjT(){
        queue=new LinkQueueObj();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public void push(int value){
        queue.insertLast(value);
    }
    public int pop(){
        return queue.deleteFirst();
    }
    public void desPlay(){
        queue.desPlay();
    }
}
