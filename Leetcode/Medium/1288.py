# https://leetcode.com/problems/remove-covered-intervals/description/?envType=daily-question&envId=2026-07-06

class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x: (x[0], -x[1]))
        ans = len(intervals)
        mx = 0
        for start, end in intervals:
            if end <= mx:
                ans -= 1
            else:
                mx = end
        return ans