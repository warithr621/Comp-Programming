// https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/?envType=daily-question&envId=2024-09-02

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long total = 0;
        for (int x : chalk) total += x;
        k %= total;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) return i;
            k -= chalk[i];
        }
        return -1;
    }
}