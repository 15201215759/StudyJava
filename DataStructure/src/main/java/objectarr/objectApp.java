package objectarr;

public class objectApp {
    public static void main(String[] args) {
       Student[] arr1=new Student[10];
        Student s1 = new Student("1",1);
        Student s2 = new Student("2",2);
        Student s3 = new Student("3",3);
        Student s4 = new Student("4",4);
        Student s5 = new Student("5",5);
        arr1[0]=s1;
        arr1[1]=s2;
        arr1[2]=s3;
        arr1[3]=s4;
        arr1[4]=s5;
        for (int i = 0; i <arr1.length ; i++) {
            if (null!=arr1[i]) System.out.println(arr1[i]);
        }
    }
}
