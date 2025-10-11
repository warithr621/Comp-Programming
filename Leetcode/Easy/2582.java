// https://leetcode.com/problems/pass-the-pillow/

class Solution {
    public int passThePillow(int n, int time) {
        time %= (2 * n - 2);
        return time < n ? ++time : -time + (2 * n - 1);
    }
}