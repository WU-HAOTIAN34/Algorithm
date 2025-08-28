package com.kamacoder;

import java.util.Scanner;

public class KaMa288Sol {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        sc.nextLine();
        for (int i=0; i<n; i++){
            str[i] = sc.nextLine();
        }

        for (String s : str){
            if ((int)s.charAt(0)<97){
                System.out.println("indistinct");
                continue;
            }
            boolean[] b = new boolean[2];
            String res = "";
            for (int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if (c=='_'){
                    b[0] = true;
                    if (i+1>=s.length() || (i+1<s.length() && !(s.charAt(i+1)>='a' && s.charAt(i+1)<='z'))){
                        res = "indistinct";
                        break;
                    }
                }
                if (c>='A' && c<='Z'){
                    b[1] =true;
                    res+='_';
                    res+=(char)(c+'a'-'A');
                    continue;
                }
                res+=c;
            }
            if (b[0]&&b[1]) res = "indistinct";
            System.out.println(res);
        }
    }
}
