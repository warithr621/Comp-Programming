from collections import Counter
from math import isqrt

def solve():
	N = int(input())
	A = sorted([*map(int, input().split())])
	C = Counter(A)
	mx = A[-1]
	ans = 0
	for x, c in C.items():
		if c >= 3:
			ans += c * (c-1) * (c-2)
		limit = isqrt(mx // x)
		for itr in range(2, limit+1):
			ans += c * C.get(x * itr, 0) * C.get(x * itr * itr, 0)
	print(ans)

t = int(input())
for quack in range(t):
	solve()
