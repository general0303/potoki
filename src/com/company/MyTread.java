package com.company;

import java.util.Scanner;

public class MyTread extends Thread{
    private static int money;
    static boolean flag=true;
    MyTread(int m){
        this.money=m;
    }
    private static int coins;
    static Scanner s=new Scanner(System.in);
    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        MyTread.money = money;
    }

    public static void add(int money) {
        money+=coins;
        setMoney(money);
    }
    public static void sub(int money) {
        if (coins>money) {
            System.out.print("у вас столько нет. повторите ввод\n");
            flag=false;
        }
        else {
            money -= coins;
            setMoney(money);
        }
    }
    @Override
    public void run() {
        while (true) {
            System.out.println("Пополнить или снять? (+/-)");
            Main.m=s.next();
            flag=true;
            System.out.println("Введите сумму");
            coins=s.nextInt();
            if (Main.m.equals("+"))
                add(money);
            else if (Main.m.equals("-"))
                sub(money);
            if (flag) System.out.print("Операция прошла успешно. У вас на счету " + money + "$\n");
        }
    }
}
