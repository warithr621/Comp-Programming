// https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public boolean isSubsequence(String s, String t) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{0, 0}); // s index, t index
        while (!q.isEmpty()) {
            Integer[] arr = q.poll();
            int x = arr[0], y = arr[1];
            if (x == s.length()) return true;
            if (y == t.length()) continue;
            if (s.charAt(x) == t.charAt(y)) {
                q.add(new Integer[]{x+1, y+1});
            } else {
                q.add(new Integer[]{x, y+1});
            }
        }
        return false;
    }


    public boolean queueless(String s, String t) {
        // uses pointers rather than a BFS-like queue
        int len = 0, ptr = 0;
        for (int i = 0; i < s.length(); i++) {
            while (ptr < t.length()) {
                if (s.charAt(i) == t.charAt(ptr)) {
                    ++len;
                    ++ptr;
                    break;
                }
                ++ptr;
            }
        }
        return len == s.length();
    }
}