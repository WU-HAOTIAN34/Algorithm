package com.leetcode;

public class LeeCo165Sol {

    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        int p1 = 0;
        int p2 = 0;
        while (p1<a.length || p2<b.length){

            if (p1<a.length && p2<b.length){
                int fir = Integer.parseInt(a[p1]);
                int sec = Integer.parseInt(b[p2]);
                if (fir>sec){
                    return 1;
                }else if (fir<sec){
                    return -1;
                }
                p1++;
                p2++;
            }else if (p1<a.length){
                if (Integer.parseInt(a[p1])>0) return 1;
                p1++;
            }else{
                if (Integer.parseInt(b[p2])>0) return -1;
                p2++;
            }
        }

        return 0;
    }
}
