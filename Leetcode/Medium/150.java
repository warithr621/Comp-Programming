// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/


class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> st = new LinkedList<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                int y  = st.pop(), x = st.pop();
                st.push(x + y);
            } else if (str.equals("-")) {
                int y  = st.pop(), x = st.pop();
                st.push(x - y);
            } else if (str.equals("*")) {
                int y  = st.pop(), x = st.pop();
                st.push(x * y);
            } else if (str.equals("/")) {
                int y  = st.pop(), x = st.pop();
                st.push(x / y);
            } else st.push(Integer.parseInt(str));
        }
        return st.pop();
    }
}