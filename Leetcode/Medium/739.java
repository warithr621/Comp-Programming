// https://leetcode.com/problems/daily-temperatures/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        LinkedList<Integer> st = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (st.size() != 0) {
                if (temperatures[i] > temperatures[st.peek()]) {
                    ans[st.peek()] = i - st.peek();
                    st.pop();
                } else break;
            }
            st.push(i);
        }
        return ans;
    }
}