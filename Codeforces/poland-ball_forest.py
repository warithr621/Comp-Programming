# https://codeforces.com/contest/755/problem/C

import sys
n = int(input())
a = list(map(int, input().split()))
ans = 0
s = set()
for i in range(n):
	if a[i] == i+1:
		ans += 1
	else:
		s.add(a[i])
print(ans + len(s)//2)
