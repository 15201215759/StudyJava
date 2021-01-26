package DoubleLink;
/**
 * 双向链表 双端
 */
public class DLink {
    private LinkNode first;
    private LinkNode last;

    public DLink(){
     first=null;
     last=null;
    }

    public boolean isEmpty(){
        return first==null;
    }

    /**
     * 从前插入数据
     * @param value
     */
    public void insertFirst(int value){
        LinkNode linkNode = new LinkNode(value);
        if (isEmpty()){
            last=linkNode;
        }else {
            first.previous=linkNode;
        }
        linkNode.next=first;
        first=linkNode;
    }

    /**
     * 从后端插入数据
     * @param value
     */
    public void insertLast(int value){
        LinkNode linkNode = new LinkNode(value);
        if (isEmpty()){
            first=linkNode;
        }else{
            last.next=linkNode;
            linkNode.previous=last;
        }
        last=linkNode;
    }
    /**
     * 删除第一个
     * @return
     */
    public LinkNode deleteFirst(){
        LinkNode temp=first;
        if (first.next==null){
            last=null;
        }else {
            first.next.previous=null;
        }
        first=first.next;
        return temp;
    }
    /**
     * 删除最后一个
     * @return
     */
    public LinkNode deleteLast(){
        LinkNode temp=last;
        if (last.previous==null){
            first=null;
        }else {
            last.previous.next=null;
        }
        last=last.previous;
        return temp;
    }
    /**
     * 插入到指定的节点后
     * @param key
     * @param value
     * @return
     */
    public boolean insetAfter(int key,int value){
        LinkNode current=first;
        while ( current.data!=key){
            if (current==null){
                return false;
            }
            current=current.next;
        }
        LinkNode linkNode = new LinkNode(value);
        if (current==last){
            linkNode.next=null;
            last=linkNode;
        }else {
            current.next.previous=linkNode;
            linkNode.next=current.next;
        }
        linkNode.previous=current;
        current.next=linkNode;
        return true;
    }
    /**
     * 删除指定的节点
     * @param key
     * @return
     */
    public LinkNode deleteKey(int key){
        LinkNode current=first;
        while (current.data!=key){
            if (current==null){
                return null;
            }
            current=current.next;
        }
        if (current==first){
            first=current.next;
        }else {
            current.next.previous=current.previous;
        }
        if (current==last){
            last=current.previous;
        }else {
         current.previous.next=current.next;
        }
        return current;
    }
    /**
     * 从前显示
     */
    public void desplayFarword(){
        LinkNode current=first;
        while (current!=null){
            current.desplay();
            current=current.next;
        }
        System.out.println();
    }
    /**
     * 从后显示
     */
    public void desplayBackword(){
        LinkNode current=last;
        while (current!=null){
            current.desplay();
            current=current.previous;
        }
        System.out.println();
    }
}
