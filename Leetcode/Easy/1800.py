# https://leetcode.com/problems/maximum-ascending-subarray-sum/description/?envType=daily-question&envId=2025-02-04

class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        ans, running = max(nums), nums[0]
        for i in range(1, len(nums)):
            if nums[i] > nums[i-1]:
                running += nums[i]
            else:
                ans = max(ans, running)
                running = nums[i]
        return max(ans, running)