package Link;

/**
 * 单链表的节点类
 */
public class SingleListNode {
   public int age;
   public double money;
   public SingleListNode next;

    public SingleListNode(int age, double money) {
        this.age = age;
        this.money = money;
    }
    public void desplay(){
        System.out.println("age:"+age+"-------"+"moeny"+money);
    }
}
