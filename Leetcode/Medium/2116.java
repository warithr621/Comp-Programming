// https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/description/?envType=daily-question&envId=2025-01-12

class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if ((n & 1) == 1) return false;
        Stack<Integer> unlocked = new Stack<>();
        Stack<Integer> open = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') unlocked.push(i);
            else if (s.charAt(i) == '(') open.push(i);
            else if (s.charAt(i) == ')') {
                if (!open.empty()) open.pop();
                else if (!unlocked.empty()) unlocked.pop();
                else return false;
            }
        }
        while (!open.empty() && !unlocked.empty() && open.peek() < unlocked.peek()) {
            open.pop();
            unlocked.pop();
        }
        return open.empty();
    }
}