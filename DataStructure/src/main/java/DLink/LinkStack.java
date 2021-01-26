package DLink;

/**
 * 用链表实现栈  抽象数据类型
 */
public class LinkStack {

    public static void main(String[] args) {
        LinkStackT linkStackT = new LinkStackT();
        linkStackT.push(1);
        linkStackT.push(2);
        linkStackT.push(3);
        linkStackT.push(4);
        linkStackT.desplay();
        linkStackT.pop();
        linkStackT.pop();
        linkStackT.desplay();
    }
}

/**
 * 链表的节点
 */
class LinkNodeD{
  public int Data;
  public LinkNodeD Next;

    public LinkNodeD(int data) {

        Data = data;
    }
    public void desplay(){
        System.out.print("Data---"+Data);
    }
}

/**
 * 抽象数据类型 链表实现栈
 */
class LinkSt{
    private LinkNodeD first;

    public LinkSt() {
        first=null;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public void insertFirst(int value){
        LinkNodeD linkNodeD = new LinkNodeD(value);
        linkNodeD.Next=first;
        first=linkNodeD;
    }
    public int deleteFirst(){
        LinkNodeD temp=first;
        first=first.Next;
        return temp.Data;
    }
    public void desplay(){
        LinkNodeD current=first;
        while (current!=null){
            current.desplay();
            current=current.Next;
        }
        System.out.println();
    }
}

/**
 * 用链表实现栈
 */
class LinkStackT{
    private LinkSt stack;

    /**
     * 用构造方法创建栈
     */
    public LinkStackT(){
        stack=new LinkSt();
    }

    /**
     * 直接调用链表类的方法来实现压入，弹出的方法
     * @return
     */
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public void push(int value){
        stack.insertFirst(value);
    }
    public int pop(){
        return stack.deleteFirst();
    }
    public void desplay(){
        stack.desplay();
    }
}
