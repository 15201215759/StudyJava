package DoubleLink;

/**
 * 双向链表节点类
 */
public class LinkNode {
    public int data;
    public LinkNode next; //下一个节点
    public LinkNode previous;//前一个节点

    public LinkNode(int value){
        data=value;
    }

    public void desplay(){
        System.out.print("Data---"+data+" ");
    }
}
