// https://leetcode.com/problems/vowels-game-in-a-string/

import java.util.*;

class Solution {
    public boolean doesAliceWin(String s) {
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        }
        return false;
    }
    public boolean regex(String s) {
        // way easier to type, but so much slower and memory-intensive
        return s.matches(".*[aeiou].*");
    }
}