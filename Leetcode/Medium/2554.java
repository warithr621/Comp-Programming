// https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/description/?envType=daily-question&envId=2024-12-06

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int check = 0, sum = 0, count = 0;
        Set<Integer> b = new HashSet<>();
        for (int x : banned) b.add(x);
        for (int i = 1; i <= n; i++) {
            if (!b.contains(i)) {
                sum += i;
                if (sum > maxSum) return count;
                ++count;
            }
        }
        return count;
    }
}