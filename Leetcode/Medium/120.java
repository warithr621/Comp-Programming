// https://leetcode.com/problems/triangle/description/


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<List<Integer>> inv = new ArrayList<>(); // i wanna invert the triangle
        int n = triangle.size();
        for (int i = n-1; i >= 0; --i) inv.add(triangle.get(i));

        System.out.println(inv);
        int[][] paths = new int[n][n];
        for (int i = 0; i < n; i++) paths[0][i] = inv.get(0).get(i);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                paths[i][j] = inv.get(i).get(j) + Math.min(paths[i-1][j], paths[i-1][j+1]);
            }
        }
        return paths[n-1][0];
    }
}