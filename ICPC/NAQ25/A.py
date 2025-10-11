# A

import math
from collections import deque, defaultdict, Counter
from heapq import heappush, heappop
from itertools import product, permutations
MOD = int(1e9+7)

r, g, b = map(int, input().split())
cr, cg, cb = map(int, input().split())
crg, cgb = map(int, input().split())

needed = 0
if r > cr:
	bought = min(r - cr, crg)
	needed += bought
	crg -= bought
	cr += bought
if b > cb:
	bought = min(b - cb, cgb)
	needed += bought
	cgb -= bought
	cb += bought
if g > cg:
	bought = min(g - cg, crg + cgb)
	needed += bought
	crg -= min(bought, crg)
	cgb -= max(0, bought - crg)
	cg += bought
# print(r,g,b)
# print(cr,cg,cb)
if r <= cr and g <= cg and b <= cb:
	print(needed)
else:
	print(-1)