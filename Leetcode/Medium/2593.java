// https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/description/?envType=daily-question&envId=2024-12-13

class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n+2];
        long ans = 0;
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        for (int i = 0; i < n; i++) pq.add(new int[]{nums[i], i});
        while (!pq.isEmpty()) {
            int[] arr = new int[2];
            do {
                if (pq.isEmpty()) break;
                arr = pq.poll();
            } while (vis[arr[1]+1]);
            if (vis[arr[1]+1]) break;
            ans += arr[0];
            // System.out.println(Arrays.toString(arr));
            for (int k = arr[1]-1; k <= arr[1]+1; k++) vis[k+1] = true;
            // System.out.println(Arrays.toString(vis));
        }
        return ans;
    }
}