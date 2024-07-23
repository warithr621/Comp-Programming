# https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/description/

class Solution:
    def minChanges(self, n: int, k: int) -> int:
        x, y = n, k
        cnt = 0
        while x > 0 or y > 0:
            if (x & 1) == 1 and (y & 1) == 0:
                cnt += 1
            if (x & 1) == 0 and (y & 1) == 1:
                return -1
            x >>= 1
            y >>= 1
        return cnt