#Problem: https://codeforces.com/contest/545/problem/B
s = input()
t = input()
n = 0
for i in range(len(s)):
    if s[i] != t[i]:
        n += 1
if n % 2 == 1:
    print("impossible")
    exit()
x = n//2
for i in range(len(s)):
    if s[i] == t[i]:
        print(s[i], end='')
    else:
        print(s[i] if n > x else t[i], end='')
        n -= 1
