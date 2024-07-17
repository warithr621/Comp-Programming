# https://leetcode.com/problems/three-divisors/

import math

class Solution(object):
    def isThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if int(sqrt(n)) != sqrt(n):
            return False
        n = int(sqrt(n))
        if n == 1:
            return False
        i = 2
        while i * i <= n:
            if n % i == 0:
                return False
            i += 1
        return True