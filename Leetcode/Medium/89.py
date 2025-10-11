# https://leetcode.com/problems/gray-code/

class Solution:
    def grayCode(self, n: int) -> List[int]:
        ans = [0]
        while len(ans) != (1 << n):
            rep = ans.copy()[::-1]
            rep = [x + len(ans) for x in rep]
            ans.extend(rep)
        return ans