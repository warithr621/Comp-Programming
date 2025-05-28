class Solution {
    public int differenceOfSums(int n, int m) {
        int x = n / m;
        int num2 = x * (x+1) / 2 * m;
        int num1 = n * (n+1) / 2 - num2;
        // System.out.println(num1 + " " + num2);
        return num1 - num2;
    }
}