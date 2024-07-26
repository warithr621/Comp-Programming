# https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

class Solution:
    def minPartitions(self, n: str) -> int:
        return ord(sorted(n)[-1]) - ord('0')
        # in essence, the biggest digit found in the number