// https://leetcode.com/problems/filling-bookcase-shelves/description/?envType=daily-question&envId=2024-07-31

class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        // note that the books MUST be placed in this order
        int[] dp = new int[books.length + 1];
        dp[1] = books[0][1]; // base case alongside dp[0]
        for (int i = 2; i <= books.length; i++) {
            int leftover = shelfWidth - books[i-1][0];
            int mxh = books[i-1][1];
            dp[i] = books[i-1][1] + dp[i-1]; // keep all other books, and make new shelf
            // we now also have the option of making a book with 'i' and some other books we've seen
            int j = i-1;
            while (j > 0 && leftover - books[j-1][0] >= 0) {
                // while we can still actually make a shelf
                mxh = Math.max(mxh, books[j-1][1]);
                leftover -= books[j-1][0];
                dp[i] = Math.min(dp[i], mxh + dp[--j]);
            }
        }
        return dp[books.length];
    }
}