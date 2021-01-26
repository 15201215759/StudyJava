package DLink;

/**
 * 链表节点类
 */
public class LinkNode {
    public int Data;
    public LinkNode Next;

    public LinkNode(int data) {
        Data = data;

    }
    public void desplay(){
        System.out.println("Data----"+Data+"Next----"+Next);
    }
}
