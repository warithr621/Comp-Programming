# https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/

class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        ans, left, mn, mx = 0, -1, -1, -1
        for i in range(len(nums)):
            if nums[i] < minK or nums[i] > maxK:
                left = i
            if nums[i] == maxK:
                mx = i
            if nums[i] == minK:
                mn = i
            ans += max(0, min(mn, mx) - left)
        return ans
        