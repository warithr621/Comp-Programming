#Problem: https://codeforces.com/contest/1085/problem/A

s = input()
L = len(s)
if L % 2 == 0:
    for i in range(L//2):
        print(s[L//2-1-i], s[L//2+i], end='', sep='')
else:
    print(s[L//2], end='')
    for i in range(1, L//2+1):
        print(s[L//2+i], s[L//2-i], sep='', end='')
