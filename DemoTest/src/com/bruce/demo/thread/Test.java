package com.bruce.demo.thread;

import java.util.concurrent.locks.ReentrantLock;

public class Test implements Runnable{
    private static ReentrantLock lock=new ReentrantLock(true);
    public void run() {
        while(true){
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }finally{
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
    	Test lft=new Test();
        Thread th1=new Thread(lft);
        Thread th2=new Thread(lft);
        th1.start();
        th2.start();
    }
}
//public class Test {
//    public volatile int inc = 0;
//
//    public void increase() {
//        inc++;
//    }
//
//    public static void main(String[] args) {
//        final Test test = new Test();
//        for(int i=0;i<10;i++){
//            new Thread(){
//                public void run() {
//                    for(int j=0;j<1000;j++)
//                        test.increase();
//                };
//            }.start();
//        }
//
//        while(Thread.activeCount()>1) 
//            Thread.yield();
//        System.out.println(test.inc);
//    }
//}