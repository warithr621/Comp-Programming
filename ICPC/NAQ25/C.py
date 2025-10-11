# C

import math
from collections import deque, defaultdict, Counter
from heapq import heappush, heappop
from itertools import product, permutations
MOD = int(1e9+7)

n, k = map(int, input().split())
a = []
for _ in range(n):
	a.append(int(input()))
a = set(a)
print(min(k, len(a)))