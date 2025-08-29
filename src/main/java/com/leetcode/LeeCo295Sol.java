package com.leetcode;

import java.util.PriorityQueue;

public class LeeCo295Sol {

    public MedianFinder medianFinder = new MedianFinder();

    class MedianFinder {

        PriorityQueue<Integer> fir;
        PriorityQueue<Integer> sec;

        public MedianFinder() {
            fir = new PriorityQueue<>((a, b)-> {return b-a;});
            sec = new PriorityQueue<>();

        }

        public void addNum(int num) {
            if (fir.size()==0 || fir.peek()>=num){
                fir.add(num);
            }else{
                sec.add(num);
            }
            if (sec.size()>fir.size()){
                fir.add(sec.poll());
            }else if (fir.size()>sec.size()+1){
                sec.add(fir.poll());
            }
        }

        public double findMedian() {
            if (fir.size()==sec.size()){
                return ((double) fir.peek() + (double) sec.peek()) / 2;
            }else{
                return (double) fir.peek();
            }
        }
    }
}
