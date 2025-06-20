// https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/description/?envType=daily-question&envId=2025-06-15

class Solution {
    public int maxDiff(int num) {
        // make big small prob
        String s = Integer.toString(num);
        char[] a = new char[s.length()], b = new char[s.length()];
        char aa = s.charAt(0);
        char bb = s.charAt(0);
        for (int i = 1; aa <= '1' && i < s.length(); i++) aa = s.charAt(i);
        for (int i = 1; bb == '9' && i < s.length(); i++) bb = s.charAt(i);
        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i) == aa ? (s.charAt(0) == aa ? '1' : '0') : s.charAt(i);
            b[i] = s.charAt(i) == bb ? '9' : s.charAt(i);
        }
        int A = Integer.parseInt(String.valueOf(a));
        int B = Integer.parseInt(String.valueOf(b));
        return B - A;
    }
}