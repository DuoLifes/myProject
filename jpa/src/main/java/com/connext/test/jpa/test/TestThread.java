package com.connext.test.jpa.test;

public class TestThread extends Thread{
    public TestThread(String name) {
        super(name);
    }

    public void run() {
        for(int i = 0;i<100;i++){
            System.out.println(this.getName()+" :"+i);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new TestThread("阿三");
        Thread t2 = new TestThread("李四");
        t1.start();
        t2.start();
    }
}