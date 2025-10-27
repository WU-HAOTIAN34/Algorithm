package com.interview;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Race {

    static int[] times = new int[4];
    static CountDownLatch cd = new CountDownLatch(4);
    static CyclicBarrier cb = new CyclicBarrier(5);

    public static void main(String[] args) {
        for (int i=1; i<5; i++){
            Task t = new Task(i);
            t.start();
        }
        try{
            cb.await();
            System.out.println("发令");
            cd.await();
            for (int i=1; i<5; i++){
                System.out.println(i+"号选手成绩："+times[i-1]+"s");
            }

        }catch (Exception e){}

    }

    static private class Task extends Thread{
        private int id;
        public Task(int i){
            id = i;
        }
        public void run(){
            int time = (int)(Math.random()*10);
            try{
                cb.await();
                Thread.sleep(time*1000);
                times[id-1] = time;
                cd.countDown();
            }catch(Exception e){}
        }
    }

}
