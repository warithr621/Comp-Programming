// https://leetcode.com/problems/strong-password-checker/

class Solution {
    public int strongPasswordChecker(String password) {
        char[] pw = password.toCharArray();
        int missing = 3;
        boolean lower = false, upper = false, digit = false;
        for (char c : pw) {
            lower |= ('a' <= c && c <= 'z');
            upper |= ('A' <= c && c <= 'Z');
            digit |= ('0' <= c && c <= '9');
        }
        if (lower) --missing;
        if (upper) --missing;
        if (digit) --missing;
        int changes = 0, mod0 = 0, mod1 = 0, n = password.length();
        int i = 2;
        while (i < n) {
            if (pw[i-2] == pw[i-1] && pw[i-1] == pw[i]) {
                int seq = 2;
                while (i < n && pw[i] == pw[i-1]) {
                    ++i;
                    ++seq;
                }
                changes += seq / 3;
                if (seq % 3 == 0) ++mod0;
                if (seq % 3 == 1) ++mod1;
            } else ++i;
        }
        if (n < 6) return Math.max(missing, 6 - n);
        else if (n <= 20) return Math.max(missing, changes);
        else {
            int del = n - 20;
            changes -= Math.min(del, mod0);
            changes -= Math.min(Math.max(del - mod0, 0), 2 * mod1) / 2;
            changes -= Math.max(del - mod0 - 2 * mod1, 0) / 3;
            return del + Math.max(missing, changes);
        }
    }
}