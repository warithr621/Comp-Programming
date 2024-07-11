// https://leetcode.com/problems/valid-parentheses/description/


import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') st.push(c);
            else {
                // it's an ending character
                if (st.size() == 0) {
                    // we can't even pop anything
                    return false;
                }
                char comp = st.pop();
                if (comp == '(' && c == ')' || comp == '{' && c == '}' || comp == '[' && c == ']') continue;
                return false;
            }
        }
        return st.size() == 0;
    }
}