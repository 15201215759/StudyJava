package ItertorLink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ItertorLinkApp {
    public static void main(String[] args) throws IOException {
        ItertorLinkClass itertorLinkClass = new ItertorLinkClass();
        LinkItertor itertor = itertorLinkClass.getItertor();
        long value;
        itertor.insertAfter(20);
        itertor.insertAfter(40);
        itertor.insertAfter(80);
        itertor.insertBefore(100);
        //控制台输入
        //s:显示链表内容
        //r:重置reset()
        //n:移动到下一个连接点
        //g:获取当前节点
        //b:在当前节点前插入
        //a:在当前节点后插入
        //d:删除当前节点
        while (true){
            System.out.println("Enter first letter of show ,reset,next,get,before,after,delete");
            System.out.flush();
            int choice=getChar();
            switch (choice){
                case 's':
                    if (!itertorLinkClass.isEmpyt()){
                        itertorLinkClass.desplay();
                    }else {
                        System.out.println("Is Empty!");
                    }
                    break;
                case 'r':
                    itertor.reset();
                    break;
                case 'n':
                    if (!itertorLinkClass.isEmpyt()&&!itertor.atEnd()){
                        itertor.nextNode();
                    }else {
                        System.out.println("Can't next");
                    }
                    break;
                case 'g':
                    if (!itertorLinkClass.isEmpyt()){
                        long data = itertor.currentNode().data;
                        System.out.println(data);
                    }else {
                        System.out.println("Is Empty!");
                    }
                    break;
                case 'b':
                    System.out.println("Enter insert value");
                    System.out.flush();
                    value=getInt();
                    itertor.insertBefore(value);
                    break;
                case 'a':
                    System.out.println("Enter insert value");
                    System.out.flush();
                    value=getInt();
                    itertor.insertAfter(value);
                    break;
                case 'd':
                    if (!itertorLinkClass.isEmpyt()){
                        long deletevalue = itertor.deleteCurrentNode();
                        System.out.println(deletevalue);
                    }else {
                        System.out.println("Can't delete");
                    }
                    break;
                default:
                    System.out.println("Invalid Enter");
                    break;
            }
        }
    }
        public static String getString() throws IOException{
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        return s;
        }

        public static char getChar() throws  IOException{
            String string = getString();
            return string.charAt(0);
        }

        public static int getInt()throws  IOException{
            String string = getString();
            return Integer.parseInt(string);
        }

}
