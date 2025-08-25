package com.kamacoder;

import java.util.LinkedList;
import java.util.Scanner;

public class KaMa18Sol {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> l = new LinkedList<>();
        String s = scanner.nextLine();
        String[] nums = s.split(" ");
        for (int i=nums.length-1; i>0; i--){
            l.add(Integer.parseInt(nums[i]));
        }
        int n = scanner.nextInt();
        s = scanner.nextLine();
        while (n>0){
            s = scanner.nextLine();
            String[] com = s.split(" ");
            if (com[0].equals("show")){
                if (l.size()==0){
                    System.out.println("Link list is empty");
                    n--;
                    continue;
                }
                String res = "";
                for (int i=0; i<l.size(); i++){
                    res += l.get(i);
                    if (i!=l.size()-1){
                        res += " ";
                    }
                }
                System.out.println(res);
            }else if (com[0].equals("insert")){
                int a = Integer.parseInt(com[1]);
                int b = Integer.parseInt(com[2]);
                if (a-1>l.size()){
                    System.out.println("insert fail");
                }else{
                    l.add(a-1, b);
                    System.out.println("insert OK");
                }
            }else if (com[0].equals("delete")){
                int a = Integer.parseInt(com[1])-1;
                if (a>=l.size()){
                    System.out.println("delete fail");
                }else{
                    l.remove(a);
                    System.out.println("delete OK");
                }
            }else{
                int a = Integer.parseInt(com[1]);
                if (a>l.size()){
                    System.out.println("get fail");
                }else{
                    System.out.println(l.get(a-1));
                }
            }
            n--;
        }
    }
}
