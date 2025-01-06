// https://leetcode.com/problems/maximum-matrix-sum

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        // surely we can either flip everything or flip everything but one
        long sum = 0, negs = 0, mn = Integer.MAX_VALUE;
        for (int[] arr : matrix) {
            for (int x : arr) {
                sum += Math.abs(x);
                if (x < 0) negs++;
                mn = Math.min(mn, Math.abs(x));
            }
        }
        return sum - (negs % 2 == 0 ? 0 : 2*mn);
    }
}