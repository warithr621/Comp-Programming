# I

import math
from collections import deque, defaultdict, Counter
from heapq import heappush, heappop
from itertools import product, permutations
MOD = int(1e9+7)

n = int(input())
a = [*map(int, input().split())]
s = [*map(int, input().split())]
s.sort(reverse=True)
ans = 0
runner = 0
for i in range(n):
	runner += s[i]
	ans = max(ans, (runner + a[i]) / (i + 1))
print(f"{ans:.6f}")