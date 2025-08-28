package com.kamacoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KaMa289Sol {

    static Map<Integer, Integer> map = new HashMap<>();
    static List<Integer> l = new ArrayList<>();
    static int res=0;

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }

        long time = 1;
        for (int i :map.keySet()){
            int tmp = map.get(i);
            while (tmp>1){
                time*=tmp;
                tmp--;
            }
        }

        backtracking(n, 0);
        System.out.println(res*time);
    }

    public static void backtracking(int n, int now){
        if (n==now){
            res++;
            return;
        }
        for (int i : map.keySet()){
            if (map.get(i)>0 && (l.size()==0 || l.get(l.size()-1)%i==0 || i%l.get(l.size()-1)==0)){
                map.put(i, map.get(i)-1);
                l.add(i);
                backtracking(n, now+1);
                map.put(i, map.get(i)+1);
                l.remove(l.size()-1);
            }
        }

    }
}
