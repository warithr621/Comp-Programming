class Solution {

    static final int MOD = 1_000_000_007;

    static long[][] multiply(long[][] a, long[][] b) {
        // assume the dimensions are fine
        int n = a.length, sz = b.length, m = b[0].length;
        long[][] res = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < sz; k++) {
                long aik = a[i][k];
                for (int j = 0; j < m; j++) {
                    res[i][j] = (res[i][j] + aik * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }

    static long[][] power(long[][] matrix, int exp, int N) {
        long[][] res = new long[N][N];
        for (int i = 0; i < N; i++) {
            res[i][i] = 1; // identity matrix
        }
        while (exp != 0) {
            if ((exp & 1) == 1) res = multiply(res, matrix);
            exp >>= 1;
            matrix = multiply(matrix, matrix);
        }
        return res;
    }

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[][] transformation = new long[26][26];
        for (int j = 0; j < nums.size(); j++) {
            for (int i = j + 1; i <= j + nums.get(j); i++) {
                transformation[i % nums.size()][j]++;
            }
        }
        transformation = power(transformation, t, 26);
        long[][] freq = new long[26][1];
        for (char c : s.toCharArray()) freq[c - 'a'][0]++;
        long[][] end = multiply(transformation, freq);
        long ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = (ans + end[i][0]) % MOD;
        }
        return (int) ans;
    }

}