package SortLink;

public class SortLintApp {
    public static void main(String[] args) {
        SortLinkObj sortLinkObj = new SortLinkObj();
        sortLinkObj.insert(60);
        sortLinkObj.insert(10);
        sortLinkObj.insert(40);
        sortLinkObj.insert(90);
        sortLinkObj.desplay();
        sortLinkObj.insert(1);
        sortLinkObj.insert(22);
        sortLinkObj.insert(68);
        sortLinkObj.insert(33);
        sortLinkObj.desplay();
        sortLinkObj.remove();
        sortLinkObj.desplay();
        sortLinkObj.remove();
        sortLinkObj.desplay();
    }
}
