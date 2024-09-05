# https://leetcode.com/problems/find-the-key-of-the-numbers/

class Solution:
    def generateKey(self, num1: int, num2: int, num3: int) -> int:
        a, b, c = str(num1), str(num2), str(num3)
        a, b, c = '0' * (4-len(a)) + a, '0' * (4-len(b)) + b, '0' * (4-len(c)) + c
        ans = 0
        for i in range(4):
            ans += 10**(3-i) * (min(ord(a[i]), ord(b[i]), ord(c[i])) - ord('0'))
            print(ans)
        return ans