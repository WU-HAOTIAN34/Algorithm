package com.kamacoder;

import java.util.*;
import java.io.*;

public class KaMa280Sol {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        Map<Long, Integer> map1 = new HashMap<>();
        Map<Long, Integer> map2 = new HashMap<>();
        long[] num1 = new long[m];
        long[] num2 = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++){
            num1[i] = Long.parseLong(st.nextToken());
            map1.put(num1[i], i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            num2[i] = Long.parseLong(st.nextToken());
            map2.put(num2[i], i);
        }

        Arrays.sort(num1);
        Arrays.sort(num2);
        int l = 0;
        int r = n-1;
        long minN = Long.MAX_VALUE;
        int[] res = new int[2];
        while (l<m && r>=0){
            long tmp = num1[l]+num2[r];
            long now = Math.abs(x-tmp);
            if (now<minN || (now==minN && map1.get(num1[l])*10+map2.get(num2[r])<res[0]*10+res[1])){
                minN = now;
                res[0] = map1.get(num1[l]);
                res[1] = map2.get(num2[r]);
            }
            if (tmp==x){
                l++;
            }else if (tmp>x){
                r--;
            }else{
                l++;
            }
        }
        System.out.println(res[0]+" "+res[1]);

    }
}
