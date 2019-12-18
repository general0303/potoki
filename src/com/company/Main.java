package com.company;

import java.util.Scanner;

public class Main {
    public static String m="";
    public static Scanner s=new Scanner(System.in);
    private static Object key=new Object();
    public  static void money(String m)throws Exception{
        synchronized (key) {
            MyTread t1=new MyTread(MyTread.getMoney());
            t1.start();
            Thread.sleep(1);
            t1.flag=false;
            key.notify();
            key.wait();
        }
    }
    public static void main(String[] args) throws Exception {
        money(m);
    }
}
