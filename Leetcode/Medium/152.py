# https://leetcode.com/problems/maximum-product-subarray/

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        ans = max(nums)
        mn, mx = 1, 1
        for x in nums:
            tmp = mx
            mx = max(x, mx * x, mn * x)
            mn = min(x, tmp * x, mn * x)
            ans = max(ans, mx)
        return ans