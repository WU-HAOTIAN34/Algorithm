package com.interview;

import java.util.concurrent.*;

public class ThreadAB {

    public static void main(String[] args) throws InterruptedException {

        FutureTask<String> ft1 = new FutureTask<>(new Task1());
        FutureTask<String> ft2 = new FutureTask<>(new Task2());
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread thread1 = new Thread(ft1);
        Thread thread2 = new Thread(ft2);

        thread1.start();
        thread2.start();

        new Thread(() -> {
            try {
                thread1.join();
                countDownLatch.countDown();
                if (thread2.isAlive()) thread2.interrupt();
            } catch (Exception e) { }
        }).start();

        new Thread(() -> {
            try {
                thread2.join();
                countDownLatch.countDown();
                if (thread1.isAlive()) thread1.interrupt();
            } catch (Exception e) { }
        }).start();

        countDownLatch.await();

        String res1 = "null";
        String res2 = "null";
        try {
             res1 = ft1.get();
        } catch (ExecutionException e) {

        }
        try {
            res2 = ft2.get();
        } catch (ExecutionException e) {

        }
        System.out.println(res1.equals(("null"))?res2:res1);
    }

    static class Task1 implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return "1";
        }
    }

    static class Task2 implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(2000);
            return "2";
        }
    }


}
