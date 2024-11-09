# https://leetcode.com/problems/rotate-string/?envType=daily-question&envId=2024-11-03

class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        return len(goal) == len(s) and goal in (2 * s)