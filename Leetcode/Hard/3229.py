# https://leetcode.com/problems/minimum-operations-to-make-array-equal-to-target/
# bro this is literally a USACO problem
# so I am going to get as close to one-linering this as possible out of boredom

class Solution:
    def minimumOperations(self, nums: List[int], target: List[int]) -> int:
        return sum(abs((nums[i] - target[i]) - (nums[i - 1] - target[i - 1])) for i in range(1, len(nums))) + abs(nums[0] - target[0]) + abs(nums[-1] - target[-1]) >> 1

    def readable(self, nums: List[int], target: List[int]) -> int:
        diff = [0]
        for i in range(len(nums)):
            diff.append(nums[i] - target[i])
        diff, ans = diff + [0], 0
        for i in range(len(nums) + 1):
            ans += abs(diff[i] - diff[i+1])
        return ans // 2