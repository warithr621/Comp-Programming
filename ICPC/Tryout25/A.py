# stream "we go up" !!

import sys, io, os
import math
from collections import defaultdict, Counter
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
write = sys.stdout.write
MOD = int(1e9+7)

for _ in range(int(input())):
	n = int(input())
	pts = []
	for i in range(n):
		pts.append(tuple(map(int, input().split())))
	xs, ys = defaultdict(int), defaultdict(int)
	awa = defaultdict(int)
	for p in pts:
		xs[p[0]] += 1
		ys[p[1]] += 1
		awa[p] += 1
	ans = 0
	for x in xs.keys():
		ans += xs[x] * (xs[x] - 1) // 2
	for y in ys.keys():
		ans += ys[y] * (ys[y] - 1) // 2
	for p in awa.keys():
		ans -= awa[p] * (awa[p] - 1) // 2
	print(ans)