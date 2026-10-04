# https://leetcode.com/problems/insert-interval/description/

class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        if not intervals:
            return [newInterval]
        n = len(intervals)
        l, r = 0, n-1
        while l <= r:
            m = (l + r) // 2
            if intervals[m][0] < newInterval[0]:
                l = m+1
            else:
                r = m-1
        intervals.insert(l, newInterval)
        
        ans = []
        for i in intervals:
            if not ans or ans[-1][1] < i[0]:
                ans.append(i)
            else:
                ans[-1][1] = max(ans[-1][1], i[1])
        
        return ans