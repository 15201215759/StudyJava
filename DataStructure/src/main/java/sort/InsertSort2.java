package sort;



import java.util.Arrays;

public class InsertSort2 {


    public static void main(String[] args) {
        Person[] Parr=new Person[5];
        Person p1 = new Person("c", 3);
        Person p2 = new Person("a", 6);
        Person p3 = new Person("f", 7);
        Person p4 = new Person("v", 1);
        Person p5 = new Person("m", 2);
        Parr[0]=p1;
        Parr[1]=p2;
        Parr[2]=p3;
        Parr[3]=p4;
        Parr[4]=p5;

        System.out.println(Arrays.toString(Parr));
        //
        for (int i = 1; i < Parr.length; i++) {
            Person Temp = Parr[i];
            int index=i;
            while (index>0&&Parr[index-1].getName().compareTo(Temp.getName())>0){
                    Parr[index]=Parr[index-1];
                    index--;
            }
            Parr[index]=Temp;
        }
        System.out.println(Arrays.toString(Parr));
    }
}
