package com.interview;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MyDeadLock {

    static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start();
        myThread2.start();
    }

    static class MyThread1 extends Thread{

        public void run() {
            lock1.lock();
            try{
                Thread.sleep(1000);
                boolean b = lock2.tryLock(3L, TimeUnit.SECONDS);
                if (b){
                    lock2.lock();
                    lock2.unlock();
                }
            }catch (Exception e){

            }finally {
                lock1.unlock();
            }
        }

    }

    static class MyThread2 extends Thread{

        public void run() {
            lock2.lock();
            try{
                Thread.sleep(1000);
                boolean b = lock1.tryLock(3L, TimeUnit.SECONDS);
                if (b){
                    lock1.lock();
                    lock1.unlock();
                }
            }catch (Exception e){

            }finally {
                lock2.unlock();
            }
        }

    }

}
