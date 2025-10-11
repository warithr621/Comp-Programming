# F

import math
from collections import deque, defaultdict, Counter
from heapq import heappush, heappop
from itertools import product, permutations
MOD = int(1e9+7)

n, k = map(int, input().split())
a = []
for _ in range(n):
	a.append(int(input()))
a.sort()

ans = float('inf')
pfx_sum = [0] * (n + 1)
pfx_square = [0] * (n + 1)
for i in range(1, n + 1):
	pfx_sum[i] = pfx_sum[i - 1] + a[i - 1]
	pfx_square[i] = pfx_square[i - 1] + a[i - 1]**2

for i in range(n - k + 1):
	interval_sum = pfx_sum[i + k] - pfx_sum[i]
	interval_square_sum =pfx_square[i + k] - pfx_square[i]
	mu = interval_sum / k
	ans = min(ans, k * mu**2 - 2 * mu * interval_sum + interval_square_sum)
print(f"{ans:.6f}")
