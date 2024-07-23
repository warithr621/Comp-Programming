// https://leetcode.com/problems/length-of-last-word/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

class Solution {
    public int lengthOfLastWord(String s) {
        // how to do it without using a built-in
        int R = s.length() - 1;
        while (s.charAt(R) == ' ') --R;
        int L = R-1;
        while (L >= 0 && s.charAt(L) != ' ') --L;
        return R - L; 
    }

    public int builtin(String s) {
        // built-in method
        String[] words = s.split("\\s");
        return words[words.length - 1].length();
    }
}