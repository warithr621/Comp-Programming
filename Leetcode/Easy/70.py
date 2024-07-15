# https://leetcode.com/problems/climbing-stairs/

class Solution:
    def climbStairs(self, n: int) -> int:
        a = [0, 1, 2]
        for i in range(3, n+1):
            a.append(a[-1] + a[-2])
        return a[n]