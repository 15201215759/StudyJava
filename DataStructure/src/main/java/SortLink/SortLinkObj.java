package SortLink;

/**
 * 有序链表//
 */
public class SortLinkObj {
    private LinkNode first;

    public SortLinkObj(){
        first=null;
    }

    public boolean isEmpty(){
        return first==null;
    }
    public void insert(int value){
        LinkNode current =first;//当前节点
        LinkNode previous =null;//上一个节点
        LinkNode linkNode = new LinkNode(value);
        while (current!=null && value>current.data){
            previous=current;
            current=current.next;
        }
        if (previous==null)
        {first=linkNode;
        }else {
            previous.next=linkNode;
        }
        linkNode.next=current;
    }
    public LinkNode remove(){
        LinkNode temp=first;
        first=first.next;
        return temp;
    }
    public void desplay(){
        LinkNode current=first;
        while (current!=null){
            current.desplay();
            current=current.next;
        }
        System.out.println();
    }
}
