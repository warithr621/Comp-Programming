// https://leetcode.com/problems/count-good-triplets/?envType=daily-question&envId=2025-04-14

class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        // n^3 is kind of lame, let's try to do it a bit better
        int ans = 0, n = arr.length;
        int[] sum = new int[1001];
        for (int j = 0; j < n; j++) {
            for (int k = j+1; k < n; k++) {
                if (Math.abs(arr[j] - arr[k]) <= b) {
                    int lj = arr[j] - a, rj = arr[j] + a;
                    int lk = arr[k] - c, rk = arr[k] + c;
                    int left = Math.max(0, Math.max(lj, lk));
                    int right = Math.min(1000, Math.min(rj, rk));
                    if (left <= right) {
                        ans += sum[right] - (left == 0 ? 0 : sum[left-1]);
                    }
                }
            }
            for (int k = arr[j]; k <= 1000; k++) ++sum[k];
        }
        return ans;
    }
}