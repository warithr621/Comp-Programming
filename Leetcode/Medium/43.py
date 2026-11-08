# https://leetcode.com/problems/multiply-strings/description/

class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        n = max(len(num1), len(num2))
        num1 = ('0' * (n-len(num1))) + num1
        num2 = ('0' * (n-len(num2))) + num2
        # ok now our numbers are the same length

        ans = []
        carry = 0
        for i in range(n-1, -1, -1):
            cur = 0
            left, right = i, n-1
            while left < n:
                cur += int(num1[left]) * int(num2[right])
                left += 1
                right -= 1
            cur += carry
            # print(cur)
            ans.append(cur%10)
            carry = cur // 10
        for i in range(n-2, -1, -1):
            cur = 0
            left, right = 0, i
            while right >= 0:
                cur += int(num1[left]) * int(num2[right])
                left += 1
                right -= 1
            cur += carry
            # print(cur)
            ans.append(cur%10)
            carry = cur // 10
        
        while carry != 0:
            ans.append(carry % 10)
            carry //= 10
        ans = ''.join(map(str, ans[::-1]))
        return ans.lstrip('0') or '0'