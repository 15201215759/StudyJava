package DoubleLink;

public class DLinkApp {
    public static void main(String[] args) {
        DLink dLink = new DLink();
        dLink.insertFirst(1);
        dLink.insertFirst(2);
        dLink.insertFirst(3);
        dLink.insertFirst(4);
        dLink.insertFirst(5);
        dLink.insertLast(6);
        dLink.insertLast(7);
        dLink.insertLast(8);
        dLink.insertLast(9);
        dLink.insertLast(10);
        dLink.desplayBackword();
        dLink.desplayFarword();
        System.out.println("-------------");
        dLink.deleteFirst();
        dLink.desplayBackword();
        dLink.desplayFarword();
        System.out.println("-------------");
        dLink.insetAfter(1,0);
        dLink.desplayBackword();
        dLink.desplayFarword();
        System.out.println("-------------");
        dLink.deleteLast();
        dLink.desplayBackword();
        dLink.desplayFarword();
        System.out.println("-------------");
        dLink.deleteKey(0);
        dLink.desplayBackword();
        dLink.desplayFarword();
        System.out.println("-------------");
    }
}
