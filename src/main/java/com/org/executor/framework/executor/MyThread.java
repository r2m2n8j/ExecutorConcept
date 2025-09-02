package com.org.executor.framework.executor;

import static java.lang.Thread.currentThread;

public class MyThread implements Runnable{

    public MyThread(String name){
        super();
    }
    @Override
    public void run() {
        for(;;){
            System.out.println(currentThread().getName() + " priority " + currentThread().getPriority());
            System.out.println("hello run method");
        }
    }
    public  static void main(String []args){
        MyThread myThread = new MyThread("anuj");
        Thread t = new Thread(myThread);
        t.start();
        for(;;){
            System.out.println("main");
        }
    }
}
