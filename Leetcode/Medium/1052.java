// https://leetcode.com/problems/grumpy-bookstore-owner/description/


class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int[] zpfx = new int[n+1], opfx = new int[n+1]; // pfx sum for zeros and for ones
        for (int i = 0; i < n; i++) {
            zpfx[i+1] = zpfx[i] + (grumpy[i] == 0 ? customers[i] : 0);
            opfx[i+1] = opfx[i] + (grumpy[i] == 1 ? customers[i] : 0);
        }
        int ans = zpfx[n];
        for (int i = 0; i <= n - minutes; i++) {
            // we use the ungrumpy boost starting on minute i, ending on minute i + minutes - 1
            int delta = opfx[i + minutes] - opfx[i];
            System.out.println(i + " " + delta);
            ans = Math.max(ans, zpfx[n] + delta);
        }
        return ans;
    }
}