# https://leetcode.com/problems/range-product-queries-of-powers/description/?envType=daily-question&envId=2025-08-11

class Solution:
    def productQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        powers = [1 << i for i in range(30) if (n & (1 << i)) != 0]
        m = len(powers)
        MOD = int(1e9+7)
        ans = [[0 for _ in range(m)] for _ in range(m)]
        for i, x in enumerate(powers):
            ans[i][i] = x
            for j in range(i+1, m):
                ans[i][j] = ans[i][j-1] * powers[j] % MOD
        return [ans[l][r] for l,r in queries]