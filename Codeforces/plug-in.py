# https://codeforces.com/contest/81/problem/A

s = input()
stack = []
for i in range(len(s)):
    if len(stack) != 0 and stack[-1] == s[i]:
        stack.pop()
    else:
        stack.append(s[i])

print(''.join(stack))