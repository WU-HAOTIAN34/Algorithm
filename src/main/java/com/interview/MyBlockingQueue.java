package com.interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<V> {


    private final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;
    private final Queue<V> queue;
    private final int capacity;

    public MyBlockingQueue(int num){
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
        queue = new LinkedList<>();
        capacity = num;
    }

    public void add(V v){
        lock.lock();
        try{
            while (queue.size()>=capacity){
                notFull.await();
            }
            queue.add(v);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public V poll(){
        lock.lock();
        try{
            while (queue.isEmpty()){
                notEmpty.await();
            }
            V res = queue.poll();
            notFull.signalAll();
            return res;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

}
