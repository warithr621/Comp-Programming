# J

import math
from collections import deque, defaultdict, Counter
from heapq import heappush, heappop
from itertools import product, permutations
MOD = int(1e9+7)

calls = [*map(int, input().split())]
if calls[-1] % 10 == 0:
	print(10)
else:
	print(calls[-1] % 10)