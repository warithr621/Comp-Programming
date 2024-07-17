// https://leetcode.com/problems/multiply-strings/description/

class Solution {
    public String multiply(String num1, String num2) {
    	// wow implementing FOIL is hard
        if (num1.length() == 1 && num2.length() == 1) {
            return Integer.toString((num1.charAt(0) - '0') * (num2.charAt(0) - '0'));
        }
        if (num1.equals("0") || num2.equals("0")) return "0";
        int n = num1.length(), m = num2.length();
        int sz = Math.max(n, m);
        int[] x = new int[sz], y = new int[sz];
        for (int i = 1; i <= n; i++) x[sz - i] = num1.charAt(n - i) - '0';
        for (int i = 1; i <= m; i++) y[sz - i] = num2.charAt(m - i) - '0';

        // System.out.println(Arrays.toString(x) + " " + Arrays.toString(y));
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = sz - 1; i >= 0; i--) {
            int v = carry;
            for (int L = i, R = sz-1; L != sz; L++, R--) {
                v += x[L] * y[R];
            }
            // System.out.println(v);
            carry = v / 10;
            ans.append((char) ('0' + v % 10));
        }
        for (int i = sz-2; i >= 0; i--) {
            int v = carry;
            for (int L = 0, R = i; L <= i; L++, R--) {
                v += x[L] * y[R];
            }
            // System.out.println(v);
            carry = v / 10;
            if (i != 0 && v != 0) ans.append((char) ('0' + v % 10));
            else if (v != 0) ans.append(new StringBuilder(Integer.toString(v)).reverse().toString());
        }
        return ans.reverse().toString();
    }
}