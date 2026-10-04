// https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/description/?envType=daily-question&envId=2026-07-29

class Solution {

    static long C(long n, long m, long k) {
        long res = 1;
        m = Math.min(m, n-m);
        for (long i = 1; i <= m; i++) {
            res = res * (n - i + 1) / i;
            if (res > k) return k+1;
        }
        return res;
    }

    private long perm(int left, int[] bucket, long k) {
        long ways = 1;
        for (int i = 0; i < 26; i++) {
            if (bucket[i] != 0) {
                ways *= C(left, bucket[i], k);
                if (ways > k) break;
                left -= bucket[i];
            }
        }
        return ways;
    }

    public String smallestPalindrome(String s, int k) {
        int split = s.length() / 2;
        int[] bucket = new int[26];
        for (int i = 0; i < split; i++) {
            bucket[s.charAt(i) - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        long start = 1;
        for (int i = 0; i < split; i++) {
            for (int j = 0; j < 26; j++) {
                if (bucket[j] != 0) {
                    bucket[j]--;
                    long ways = perm(split - i - 1, bucket, k);
                    if (start + ways > k) {
                        ans.append((char) ('a' + j));
                        break;
                    }
                    bucket[j]++;
                    start += ways;
                }
            }
        }
        if (ans.length() < split) return ""; // less than k perms
        if (s.length() % 2 != 0) ans.append(s.charAt(split)); // odd letter lol
        for (int i = split-1; i >= 0; i--) {
            ans.append(ans.charAt(i));
        }
        return ans.toString();
    }

}