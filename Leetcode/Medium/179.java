// https://leetcode.com/problems/largest-number/?envType=daily-question&envId=2024-09-18

class Solution {

    public boolean compare(String a, String b) {
        // if true, a > b
        if (a.length() != b.length()) {
            return a.length() > b.length();
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return a.charAt(i) > b.charAt(i);
            }
        }
        return true;
    }

    public String largestNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int swaps = 0;
            for (int j = 0; j < n-1; j++) {
                String a = Integer.toString(nums[j]) + Integer.toString(nums[j+1]);
                String b = Integer.toString(nums[j+1]) + Integer.toString(nums[j]);
                if (!compare(a,b)) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    ++swaps;
                }
            }
            if (swaps == 0) break;
        }
        StringBuilder ans = new StringBuilder();
        for (int x : nums) ans.append(x);
        int idx = 0;
        while (idx < ans.length() && ans.charAt(idx) == '0') ++idx;
        if (idx == ans.length()) return "0";
        return ans.substring(idx);
    }
}