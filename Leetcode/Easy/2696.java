// https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/?envType=daily-question&envId=2024-10-07

class Solution {
    public int minLength(String s) {
        while (true) {
            int removals = 0;
            for (int i = 0; i < s.length() - 1;) {
                if (s.substring(i, i+2).equals("AB") || s.substring(i, i+2).equals("CD")) {
                    s = new StringBuilder(s.substring(0, i)).append(s.substring(i+2)).toString();
                    removals++;
                } else ++i;
            }
            if (removals == 0) break;
        }
        return s.length();
    }

    public int better(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (st.empty()) st.push(c);
            else if (st.peek() == 'A' && c == 'B') st.pop();
            else if (st.peek() == 'C' && c == 'D') st.pop();
            else st.push(c);
        }
        return st.size();
    }
}