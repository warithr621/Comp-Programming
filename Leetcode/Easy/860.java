// https://leetcode.com/problems/lemonade-change/?envType=daily-question&envId=2024-08-15

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int f = 0, t = 0;
        for (int x : bills) {
            if (x == 5) {
                // easy just add this
                ++f;
            } else if (x == 10) {
                // do we have a 5 in reserve?
                if (f == 0) return false;
                --f; ++t;
            } else {
                // one 10 one 5, or three 5
                // optimal to not give up 5s unless last resort
                if (t > 0 && f > 0) {
                    --f; --t;
                } else if (f >= 3) {
                    f -= 3;
                } else return false;
            }
        }
        return true;
    }
}