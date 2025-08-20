# https://leetcode.com/problems/maximum-69-number/?envType=daily-question&envId=2025-08-16
class Solution:
    def maximum69Number (self, num: int) -> int:
        return int(str(num).replace('6', '9', 1))