// https://leetcode.com/problems/rank-transform-of-an-array/description/?envType=daily-question&envId=2024-10-02

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();
        int[] cp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(cp);
        int idx = 1;
        for (int i = 0; i < cp.length; i++) {
            if (i > 0 && cp[i] > cp[i-1]) ++idx;
            hm.put(cp[i], idx);
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = hm.get(arr[i]);
        }
        return ans;
    }
}