// https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/?envType=daily-question&envId=2025-02-11

class Solution {

    private boolean match(Stack<Character> st, String part, int m) {
        Stack<Character> tmp = new Stack<>();
        tmp.addAll(st);
        for (int i = m-1; i >= 0; i--) {
            if (tmp.isEmpty() || tmp.peek() != part.charAt(i)) return false;
            tmp.pop();
        }
        return true;
    }

    public String removeOccurrences(String s, String part) {
        // this is KMP but idk how it works
        Stack<Character> st = new Stack<>();
        int n = s.length(), m = part.length();
        for (char c : s.toCharArray()) {
            st.push(c);
            if (st.size() >= m && match(st, part, m)) {
                for (int j = 0; j < m; j++) {
                    st.pop();
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) ans.append(st.pop());
        ans.reverse();
        return ans.toString();
    }

}