package com.Xuanli.arr;

public class arr {
    public static void main (String [] args ){
        orderarr orderarr = new orderarr(10);
        orderarr.insert(9);
        orderarr.display();
        orderarr.insert(10);
        orderarr.insert(44);
        int search = orderarr.search(10);
        System.out.println(search);
        orderarr.update(1,59);
        orderarr.display();
        long searchtwo = orderarr.searchtwo(44);

        System.out.println(searchtwo);
    }
}
