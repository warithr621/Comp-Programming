// https://leetcode.com/problems/rotate-image/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {

    public void swapper(int[][] arr, int x, int y, int xx, int yy) {
        int tmp = arr[x][y];
        arr[x][y] = arr[xx][yy];
        arr[xx][yy] = tmp;
    }

    public void rotate(int[][] matrix) {
        // ah, in-place
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                swapper(matrix, i, j, j, n - i - 1);
                swapper(matrix, i, j, n - i - 1, n - j - 1);
                swapper(matrix, i, j, n - j - 1, i);
            }
        }
    }
}