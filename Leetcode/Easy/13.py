# https://leetcode.com/problems/roman-to-integer/

class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        conv = {'I': 1, 'IV': 4, 'V': 5, 'IX': 9, 'X': 10, 'XL': 40, 
        'L': 50, 'XC': 90, 'C': 100, 'CD': 400, 'D': 500, 'CM': 900, 'M': 1000}
        prev = ''
        ans = 0
        for c in s:
            if prev == '':
                ans += conv[c]
            else:
                if (prev + c) not in conv:
                    ans += conv[c]
                else:
                    ans += conv[prev + c] - conv[prev]
            prev = c
        return ans