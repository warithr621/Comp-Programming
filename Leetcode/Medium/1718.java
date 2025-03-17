// https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/description/?envType=daily-question&envId=2025-02-16

class Solution {

    private boolean search(int idx, int[] ans, boolean[] used, int n) {
        if (idx == ans.length) return true;
        if (ans[idx] != 0) {
            // already filled up
            return search(idx+1, ans, used, n);
        }
        for (int next = n; next >= 1; --next) {
            if (used[next]) continue;
            used[next] = true;
            ans[idx] = next;
            if (next == 1) {
                // we only have one 1
                if (search(idx+1, ans, used, n)) return true;
            } else if (idx + next < ans.length && ans[idx + next] == 0) {
                // the next place is blank, let's place it
                ans[idx + next] = next;
                if (search(idx + 1, ans, used, n)) return true;
                // undo
                ans[idx + next] = 0;
            }
            // more undoing
            ans[idx] = 0;
            used[next] = false;
        }
        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[n * 2 - 1];
        boolean[] used = new boolean[n+1];
        search(0, ans, used, n);
        return ans;
    }

}