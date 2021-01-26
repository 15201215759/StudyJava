package DLink;

public class DLinkApp {
    public static void main(String[] args) {
        DLinkObject dLinkObject = new DLinkObject();
        dLinkObject.insertFirst(1);
        dLinkObject.insertFirst(2);
        dLinkObject.insertFirst(3);
        dLinkObject.insertLast(4);
        dLinkObject.insertLast(5);
        dLinkObject.insertLast(6);
        dLinkObject.desplayLink();
        System.out.println("----------------------------");
        dLinkObject.deleteFirst();
        dLinkObject.desplayLink();

    }
}
