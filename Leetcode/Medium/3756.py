# https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/description/?envType=daily-question&envId=2026-07-08

MOD = int(1e9) + 7
p10 = [1] * 100001
for i in range(1, 100001):
    p10[i] = p10[i-1] * 10 % MOD

class Solution:
    def sumAndMultiply(self, s: str, queries: List[List[int]]) -> List[int]:
        n = len(s)
        sums = [0] * (n+1)
        num = [0] * (n+1)
        cnt = [0] * (n+1)
        for i in range(n):
            d = int(s[i])
            sums[i+1] = sums[i] + d
            num[i+1] = (num[i] * 10 + d) % MOD if (d > 0) else num[i]
            cnt[i+1] = cnt[i] + (d > 0)
        m = len(queries)
        ans = [0] * m
        for i in range(m):
            l, r = queries[i][0], queries[i][1] + 1
            length = cnt[r] - cnt[l]
            ans[i] = (num[r] - num[l] * p10[length]) * (sums[r] - sums[l]) % MOD
        return ans