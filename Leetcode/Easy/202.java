// https://leetcode.com/problems/happy-number/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public boolean isHappy(int n) {
        // what is very helpful is knowing 1 and 7 are the only one-digit happies
        while (n != 1 && n != 7) {
            // System.out.println(n);
            if (n < 10) {
                // means it's a one-digit number that isn't happy
                return false;
            }
            int state = 0;
            while (n != 0) {
                state += (n % 10) * (n % 10);
                n /= 10;
            }
            n = state;
        }
        return true;
    }
}