// https://leetcode.com/problems/sum-of-digits-of-string-after-convert/?envType=daily-question&envId=2024-09-03

class Solution {
    public int getLucky(String s, int k) {
        int current = 0;
        for (char c : s.toCharArray()) {
            int value = (c - 'a' + 1);
            current += (value % 10) + (value / 10);
        }
        for (int i = 1; i < k; i++) {
            int next = 0;
            while (current != 0) {
                next += current % 10;
                current /= 10;
            }
            current = next;
        }
        return current;
    }
}