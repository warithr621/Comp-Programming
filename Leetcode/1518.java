// https://leetcode.com/problems/water-bottles/description/

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
    	// simulation
        int ans = 0, full = numBottles, empty = 0;
        while (full != 0) {
            // drink all the currently full bottles
            ans += full;
            empty += full;
            // convert the empty bottles you have into full bottles again
            full = empty / numExchange;
            empty %= numExchange;
        }
        return ans;
    }

    public int fast(int numBottles, int numExchange) {
    	// very entertaining math
    	return (--numBottles / --numExchange) + ++numBottles;
    }
}