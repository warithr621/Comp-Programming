// https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/description/?envType=daily-question&envId=2026-06-27

class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int x : nums) {
            hm.merge(x, 1, Integer::sum);
        }
        int ans = 1;
        for (int x : hm.keySet()) {
            if (x == 1) {
                int freq = hm.get(x);
                ans = Math.max(ans, freq - (1 - freq%2));
                continue;
            }
            int length = 1, cur = x;
            while (true) {
                if (Integer.MAX_VALUE / cur < cur) break;
                if (hm.get(cur) >= 2 && hm.containsKey(cur * cur)) {
                    length += 2;
                    cur *= cur;
                } else break;
            }
            ans = Math.max(ans, length);
        }
        return ans;
    }
}