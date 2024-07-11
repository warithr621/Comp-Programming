// https://leetcode.com/problems/sequential-digits/


class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        // since 1e9 can't be a good number, just decrement if it is
        if (high == (int) 1e9) --high;
        int L = Integer.toString(low).length(), R = Integer.toString(high).length();
        List<Integer> ans = new ArrayList<>();

        for (int len = L; len <= R; ++len) {
            int cur = 1, delta = 1;
            for (int i = 2; i <= len; i++) {
                cur = cur * 10 + i;
                delta = delta * 10 + 1;
            }
            if (low <= cur && cur <= high) ans.add(cur);
            while ((long) cur + delta <= Math.min(Math.pow(10, len) - 1, high)) {
                cur += delta;
                if (cur % 10 == 0) break; // for instance going from 6789 to 7890 is bad
                if (low <= cur && cur <= high) ans.add(cur);
            }
        }
        return ans;
    }
}