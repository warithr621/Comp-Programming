# Solved on Neetcode, problem is "String Encode and Decode"

class Solution:

    def encode(self, strs: List[str]) -> str:
        ans = ""
        for s in strs:
            ans += str(len(s)) + "*" + s
        return ans

    def decode(self, s: str) -> List[str]:
        ans = []
        i = 0
        while i < len(s):
            j = i
            while s[j] != '*':
                j += 1
            l = int(s[i:j])
            i = j + 1
            j = i + l
            ans.append(s[i:j])
            i = j
        return ans
