# https://atcoder.jp/contests/abc125/tasks/abc125_c
from math import gcd

n = int(input())
a = [0] + list(map(int, input().split()))

lp = [0] * (n+2)
rp = [0] * (n+2)

for i in range(n):
	lp[i+1] = gcd(lp[i], a[i])
	#lp[i] = gcd of the first 'i' elements

for i in range(n, -1, -1):
	rp[i] = gcd(rp[i+1], a[i])

ans = 0
for i in range(1, n+1):
	ans = max(ans, gcd(lp[i], rp[i+1]))

print(ans)