// https://leetcode.com/problems/water-bottles-ii/description/

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = 0, full = numBottles, empty = 0;
        while (full != 0) {
            // drink all the currently full bottles
            ans += full;
            empty += full;
            full = 0;
            // if possible, exchange
            if (empty >= numExchange) {
                full++;
                empty -= numExchange;
                ++numExchange;
            }
        }
        return ans;
    }
}