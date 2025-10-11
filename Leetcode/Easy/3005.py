# https://leetcode.com/problems/count-elements-with-maximum-frequency/description/?envType=daily-question&envId=2025-09-22

class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        f = [0 for _ in range(101)]
        for x in nums:
            f[x] += 1
        mx = max(f)
        return f.count(mx) * mx