package com.leetcode;

public class LeeCo12Sol {

    public String intToRoman(int num) {
        String res = "";
        int a = num/1000;
        num%=1000;
        int b = num/100;
        num%=100;
        int c = num/10;
        num%=10;
        int d = num;
        for (int i=0; i<a; i++) res+="M";
        if (b==9){
            res+="CM";
        }else if (b==4){
            res+="CD";
        }else{
            if (b>=5){
                res += "D";
                b-=5;
            }
            for (int i=0; i<b; i++) res+="C";
        }
        if (c==9){
            res+="XC";
        }else if (c==4){
            res+="XL";
        }else{
            if (c>=5){
                res += "L";
                c-=5;
            }
            for (int i=0; i<c; i++) res+="X";
        }
        if (d==9){
            res+="IX";
        }else if (d==4){
            res+="IV";
        }else{
            if (d>=5){
                res += "V";
                d-=5;
            }
            for (int i=0; i<d; i++) res+="I";
        }
        return res;
    }
}
