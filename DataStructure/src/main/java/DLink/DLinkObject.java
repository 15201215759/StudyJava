package DLink;

/**
 * 双端链表
 */
public class DLinkObject {
    public LinkNode First;
    public LinkNode Last;

    public DLinkObject() {
        First = null;
        Last = null;
    }
    public boolean isEmpty(){
        return First==null;
    }
    public void insertFirst(int value){
        LinkNode newLinkNode = new LinkNode(value);
        if (isEmpty())Last=newLinkNode;
        newLinkNode.Next=First;
        First=newLinkNode;
    }
    public void insertLast(int value){
        LinkNode newLinkNode = new LinkNode(value);
        if (isEmpty()){
            First=newLinkNode;
        }else {
            Last.Next=newLinkNode;
        }
        Last=newLinkNode;
    }
    public int deleteFirst(){
        int value=First.Data;
        if (isEmpty()){
            System.out.println("null");
        }else {
            if (First.Next==null){
                Last=null;
            }
            First=First.Next;

        }
        return value;
    }
    public void desplayLink(){
        LinkNode current=First;
        System.out.println("-----------");
        while (current!=null){

            current.desplay();
            current=current.Next;
        }
    }
}
