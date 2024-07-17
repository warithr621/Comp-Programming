# https://leetcode.com/problems/number-of-1-bits/?envType=study-plan-v2&envId=top-interview-150

class Solution:
    def hammingWeight(self, n: int) -> int:
        return sum([0 if (n & (1 << i)) == 0 else 1 for i in range(32)])