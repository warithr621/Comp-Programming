# https://leetcode.com/problems/compare-version-numbers/?envType=daily-question&envId=2025-09-23

class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        a = version1.split(".")
        b = version2.split(".")
        while len(a) < len(b):
            a.append("0")
        while len(b) < len(a):
            b.append("0")
        a = [*map(int, a)]
        b = [*map(int, b)]
        for x,y in zip(a,b):
            if x < y:
                return -1
            elif x > y:
                return 1
        return 0