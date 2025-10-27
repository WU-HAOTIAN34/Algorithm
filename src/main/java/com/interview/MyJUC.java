package com.interview;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class MyJUC {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(10);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        BlockingDeque<String> q = new LinkedBlockingDeque<>();
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lockInterruptibly();
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("ada");
        threadLocal.get();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        reentrantReadWriteLock.readLock().lock();
        reentrantReadWriteLock.readLock().unlock();


        try {
            semaphore.acquire();
            cyclicBarrier.await();
            countDownLatch.countDown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            semaphore.release();
        }

        countDownLatch.await();

        StampedLock stampedLock = new StampedLock();
        long l = stampedLock.readLock();
        stampedLock.unlockRead(l);
        long l1 = stampedLock.writeLock();
        stampedLock.unlockWrite(l1);
        long l2 = stampedLock.tryOptimisticRead();
        boolean validate = stampedLock.validate(l2);


        Task2 task2 = new Task2();
        task2.start();

        FutureTask<String> ft = new FutureTask<>(new Task3());
        new Thread(ft).start();
        try {
            String s = ft.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(()->{

        });
        executor.submit(new Task1());
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {

        });




    }

    static class Task1 implements Runnable {

        @Override
        public void run() {

        }
    }

    static class Task2 extends Thread {

        public void run() {

        }
    }

    static class Task3 implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "";
        }
    }
}
