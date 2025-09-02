package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeeCo68Sol {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int be = 0;
        int end = 0;
        int len = 0;
        for ( ; end<words.length; end++){
            if (len+words[end].length()<=maxWidth){
                len += words[end].length()+1;
                continue;
            }
            len--;
            int num = end-be-1;
            int space = maxWidth-len;
            String s = "";
            for (int i=0; i<end-be-1; i++){
                s += words[be+i];
                int spaN = space/num+1;
                if (i<space%num){
                    spaN++;
                }
                for (int j=0; j<spaN; j++){
                    s += " ";
                }
            }
            s += words[end-1];
            while (s.length()<maxWidth) s += " ";
            res.add(s);
            len = 0;
            be = end;
            end--;
        }
        if (be<words.length){
            String s = "";
            for ( ; be<words.length-1; be++){
                s += words[be] + " ";
            }
            s += words[be];
            while (s.length()<maxWidth) s += " ";
            res.add(s);
        }
        return res;
    }
}
