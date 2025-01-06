// https://leetcode.com/problems/fraction-addition-and-subtraction/?envType=daily-question&envId=2025-01-02
// why did I do this to myself at 2am

class Solution {

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int[] math(int[] a, int[] b, char op) {
        // System.out.println(Arrays.toString(a) + " " + Arrays.toString(b) + " " + op);
        if (a[1] == 0) a[1] = 1;
        if (b[1] == 0) b[1] = 1;
        int top = a[0] * b[1] + (op == '+' ? 1 : -1) * a[1] * b[0];
        int bottom = a[1] * b[1];
        if (Math.signum(top) == 0) return new int[]{0, 1};
        int g = gcd(Math.abs(top), Math.abs(bottom));
        if (Math.signum(top) == 1 ^ Math.signum(bottom) == 1) {
            // negative fraction
            return new int[]{-Math.abs(top) / g, Math.abs(bottom) / g};
        } else {
            // positive fraction
            return new int[]{Math.abs(top) / g, Math.abs(bottom) / g};
        }
        
    }

    public String fractionAddition(String expression) {
        int[] current = new int[]{0, 1};
        String nt = "0", nb = "0";
        boolean fixn = true;
        char op = '+';
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-') {
                current = math(current, new int[]{Integer.parseInt(nt), Integer.parseInt(nb)}, op);
                op = c;
                fixn = true;
                nt = "0"; nb = "0";
            } else if (c == '/') {
                fixn = false;
            } else if (fixn) {
                nt += c;
            } else {
                nb += c;
            }
        }
        current = math(current, new int[]{Integer.parseInt(nt), Integer.parseInt(nb)}, op);
        // System.out.println(Arrays.toString(current));
        return current[0] + "/" + current[1];
    }
}