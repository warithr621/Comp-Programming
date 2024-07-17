// https://leetcode.com/problems/merge-intervals/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        LinkedList<int[]> ll = new LinkedList<>();
        for (int[] x : intervals) {
            if (ll.size() == 0 || ll.get(ll.size()-1)[1] < x[0]) {
                ll.add(x);
            } else {
                int[] comb = new int[]{ll.get(ll.size()-1)[0], Math.max(x[1], ll.get(ll.size()-1)[1])};
                ll.pollLast();
                ll.add(comb);
            }
        }
        int[][] ans = new int[ll.size()][2];
        for (int i = 0; i < ll.size(); i++) ans[i] = ll.get(i);
        return ans;
    }
}