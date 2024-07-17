# https://leetcode.com/problems/sqrtx/?envType=study-plan-v2&envId=top-interview-150

class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        L, R = 0., x
        while L + (1e-6) < R:
            M = (L + R) / 2
            if M * M < x:
                L = M
            else:
                R = M
        return int(R)