package com.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrint {

    static ReentrantLock lock = new ReentrantLock();
    static int num = 1;
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Task task1 = new Task(1);
        Task task2 = new Task(2);
        Task task3 = new Task(3);

        task1.start();
        task2.start();
        task3.start();
    }

    static class Task extends Thread {
        private int id;
        public Task(int id){
            this.id = id;
        }
        public void run(){
            while (num<=100){
                lock.lock();
                try{
                    while (num<=100 && (num-1)%3!=(id-1)){
                        condition.await();
                    }
                    if (num<=100) System.out.println(id+": "+num);
                    num++;
                    condition.signalAll();
                }catch(Exception e){

                }finally{
                    lock.unlock();
                }
            }
        }
    }
}
