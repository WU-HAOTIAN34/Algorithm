package com.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class MyThreadPool {

    static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i=0; i<10; i++){
            pool.submit(new Task(i));
        }
        int[][] a2 = {{1,0}, {9,2}, {0,21}};

        //Arrays.sort(a, (Integer[] o1, Integer[] o2) -> {return o1[0]-o2[0];});
//        List<Integer> l = new ArrayList<>();
//        l.stream().map(a->a>10).filter().sorted((int a, int b)->{return a-b});
    }

    static class Task implements Callable<String> {

        private int id;

        public Task(int id) {
            this.id = id;
        }

        public String call(){
            try{
                BufferedReader br = new BufferedReader(new FileReader("asdad"));
                int num = 0;
                while (true){
                    String s = br.readLine();
                    if (s == null) break;
                    if (num%10==id){
                        map.put(s,map.getOrDefault(s,0) + 1);
                    }
                }
            }catch (IOException e){}
            return "dasdasd";
        }
    }
}
