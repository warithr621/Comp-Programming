# https://leetcode.com/problems/string-matching-in-an-array/?envType=daily-question&envId=2025-01-07

class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        ans = []
        for i, s in enumerate(words):
            for j, t in enumerate(words):
                if i == j:
                    continue
                if s in t:
                    ans.append(s)
                    break
        return ans