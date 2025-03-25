class Solution {
    public int countDays(int days, int[][] meetings) {
        int ans = days;
        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Stack<int[]> st = new Stack<>();
        for (int[] cur : meetings) {
            if (st.isEmpty()) st.push(cur);
            else {
                int[] prev = st.peek();
                if (prev[1] >= cur[0]) {
                    st.pop();
                    st.push(new int[]{Math.min(prev[0], cur[0]), Math.max(prev[1], cur[1])});
                } else {
                    st.push(cur);
                }
            }
        }
        while (!st.isEmpty()) {
            int[] arr = st.pop();
            ans -= arr[1] - arr[0] + 1;
        }
        return ans;
    }
}