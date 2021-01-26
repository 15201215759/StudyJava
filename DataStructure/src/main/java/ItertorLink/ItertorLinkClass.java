package ItertorLink;

/**
 *链表类
 */
public class ItertorLinkClass {
    private LinkNode first;

    public ItertorLinkClass(){
        first=null;
    }
    public LinkNode getFirst(){
        return first;
    }
    public void setFirst(LinkNode node){
        first=node;
    }

    public boolean isEmpyt(){
        return first==null;
    }
    public void desplay(){
        LinkNode current=first;
        while (current!=null){
            current.desplay();
            current=current.next;
        }
    }
    public LinkItertor getItertor(){
        return new LinkItertor(this);
    }
}

/**
 *链表的节点类
 */
class LinkNode{
    public long data;
    public LinkNode next;
    public LinkNode(long value){
        data=value;
    }
    public void desplay(){
        System.out.println("data----"+data);
    }

}

/**
 * 链表的迭代器
 */
class LinkItertor {
    public LinkNode current;
    public LinkNode previous;
    public ItertorLinkClass ourlink;

    public LinkItertor(ItertorLinkClass ourlink){
        this.ourlink=ourlink;
        reset();
    }

    /**
     * 重置的方法
     */
    public void reset(){
        current=ourlink.getFirst();
        previous=null;

    }

    /**
     * 判断是否为移动到最后一个
     * @return
     */
     public boolean atEnd(){
        return current.next==null;
     }

    /**
     * 向下移动一个节点
     */
    public void nextNode(){
         previous=current;
         current=current.next;
     }

    /**
     * 返回当前的节点
     * @return
     */
     public LinkNode currentNode(){
        return current;
     }

    /**
     * 在迭代器房前访问的节点后面插入一个新的节点
     * @param value
     */
     public void insertAfter(long value){
         LinkNode newNode = new LinkNode(value);
        if (ourlink.isEmpyt()){
             ourlink.setFirst(newNode);
             current=newNode;
         }else {
            newNode.next=current.next;
            current.next=newNode;
            nextNode();
        }
     }

    /**
     * 在当前迭代器操作的当前节点前插入新的节点
     * @param value
     */
     public void insertBefore(long value){
         LinkNode newNode = new LinkNode(value);
        if (previous==null){
            ourlink.setFirst(newNode);
            current=newNode;
            reset();
        }else {
            newNode.next=previous.next;
            previous.next=newNode;
            current=newNode;
        }
     }

    /**
     * 删除当前节点
     * @return
     */
     public long deleteCurrentNode(){
         long data = current.data;
         if (previous==null){
             ourlink.setFirst(current.next);
             reset();
         }else{
             previous.next=current.next;
             if (atEnd()){
                 reset();
             }else {
                 current=current.next;
             }
         }
         return data;
     }
}
