// https://leetcode.com/problems/h-index/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int L = 0, R = citations.length - 1; L < R; L++, R--) {
            int tmp = citations[L];
            citations[L] = citations[R];
            citations[R] = tmp;
        }
        int ans = 0;
        for (int i = 1; i <= citations.length; i++) {
            System.out.println(i + " " + citations[i-1]);
            if (citations[i-1] >= i) ans = i;
        }
        return ans;
    }
}