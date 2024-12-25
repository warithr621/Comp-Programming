// https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/description/?envType=daily-question&envId=2024-12-22

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        Stack<Pair<Integer, Integer>> st = new Stack<>();
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        List<List<Pair<Integer, Integer>>> nq = new ArrayList<>(heights.length);
        for (int i = 0; i < heights.length; i++) nq.add(new ArrayList<>());
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0], b = queries[i][1];
            if (a > b) {
                int tmp = a; a = b; b = tmp;
            }
            if (heights[b] > heights[a] || a == b) ans[i] = b;
            else nq.get(b).add(new Pair<>(heights[a], i));
        }
        for (int i = heights.length - 1; i >= 0; i--) {
            int sz = st.size();
            for (Pair<Integer, Integer> p : nq.get(i)) {
                int pos = bs(p.getKey(), st);
                if (pos < sz && pos >= 0) ans[p.getValue()] = st.get(pos).getValue();
            }
            while (!st.isEmpty() && st.peek().getKey() <= heights[i]) st.pop();
            st.add(new Pair<>(heights[i], i));
        }
        return ans;
    }

    private int bs(int height, Stack<Pair<Integer, Integer>> st) {
        int L = 0, R = st.size() - 1, ans = -1;
        while (L <= R) {
            int M = (L + R) >> 1;
            if (st.get(M).getKey() > height) {
                ans = Math.max(ans, M);
                L = ++M;
            } else {
                R = --M;
            }
        }
        return ans;
    }
}