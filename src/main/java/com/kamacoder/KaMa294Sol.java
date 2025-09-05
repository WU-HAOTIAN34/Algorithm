package com.kamacoder;

import java.util.*;

public class KaMa294Sol {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[][] bo = new char[n][m];
        for (int i=0; i<n; i++){
            String s = sc.nextLine();
            for (int j=0; j<m; j++){
                bo[i][j] = s.charAt(j);
            }
        }

        int[][] b = new int[n][m];
        int res = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (b[i][j]==0){
                    Queue<List<Integer>> q = new LinkedList<>();
                    int x = i;
                    int y = j;
                    while (true){
                        if (x>=0&&x<n&&y>=0&&y<m&&b[x][y]!=-1){
                            if (b[x][y]==1){
                                while (!q.isEmpty()){
                                    List<Integer> l = q.poll();
                                    b[l.get(0)][l.get(1)] = 1;
                                }
                                break;
                            }else{
                                q.add(Arrays.asList(x,y));
                                b[x][y] = 1;
                                if (bo[x][y]=='L'){
                                    y--;
                                }else if(bo[x][y]=='R'){
                                    y++;
                                }else if(bo[x][y]=='U'){
                                    x--;
                                }else{
                                    x++;
                                }
                            }
                        }else{
                            while (!q.isEmpty()){
                                List<Integer> l = q.poll();
                                b[l.get(0)][l.get(1)] = -1;
                            }
                            break;
                        }
                    }
                }
            }
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (b[i][j]==1) res++;
            }
        }
        System.out.println(res);
    }
}
