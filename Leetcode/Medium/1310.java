// https://leetcode.com/problems/xor-queries-of-a-subarray/description/?envType=daily-question&envId=2024-09-13

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // this should just be XOR prefixes right?
        // let pfx[0] = 0, pfx[1] = arr[0], pfx[2] = arr[0] ^ arr[1], etc.
        // let's say you want arr[2] ^ arr[3]
        // this should be pfx[4] ^ pfx[2]
        int[] xors = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            xors[i] = xors[i-1] ^ arr[i-1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = xors[queries[i][1] + 1] ^ xors[queries[i][0]];
        }
        return ans;
    }
}