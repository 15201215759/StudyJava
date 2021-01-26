package Link;

/**
 * 链表类
 */
public class SingleLinkList {
    private SingleListNode first;//头指针，新增从头增加

    public SingleLinkList() {
        first = null;
    }

    /**
     * 向第一个位置插入新的链表
     * @param age
     * @param money
     */
    public void insert(int age, double money){
        SingleListNode ListNode = new SingleListNode(age, money);
        ListNode.next=first;//新链表的下一个等于原来的第一个
        first=ListNode;//现在的第一个等于新创建的
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return first==null;
    }

    /**
     * 删除头一个
     * @return
     */
    public SingleListNode delete(){
       if (!isEmpty()){
           SingleListNode temp =first;
         first=first.next;
           return temp;
       }else {
           return null;
       }
    }

    /**
     * 现实链表的数据信息
     */
    public void desplay(){
        SingleListNode current=first;
        while (current!=null){
            current.desplay();
            current=current.next;
        }
        System.out.println("----------------");
    }

    /**
     * 指定查找的方法
     * @param key
     * @return
     */
    public SingleListNode find(int key){
        SingleListNode current=first;
        while (current.age!=key){
            if (current==null){
                return null;
            }else {
                current=current.next;
            }
        }
        return current;
    }

    /**
     * 删除指定的链表节点
     * @param key
     * @return
     */
    public SingleListNode delete(int key){
        SingleListNode current=first;
        SingleListNode previous=first;
        while (current.age!=key){
            if (current==null){
                return null;
            }else {
                previous=current;
                current=current.next;
            }
        }
        if (current==first){
            first=first.next;
        }else {
            previous.next=current.next;
        }
        return current;
    }
}

