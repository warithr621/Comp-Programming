# L

import math
from collections import deque, defaultdict, Counter
from heapq import heappush, heappop
from itertools import product, permutations
MOD = int(1e9+7)

n = int(input())
a = [*map(int, input().split())]
x, z = a[0] // 3, a[-1] // 3
y = a[1] - 2 * x
print(x,y,z)