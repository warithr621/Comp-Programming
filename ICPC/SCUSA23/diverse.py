# is this bitmask time

from collections import Counter

n, k = map(int, input().split())
problems = []
for _ in range(n):
	problems.append(input().split()[1:])

ans = 0
for mask in range(1 << n):
	subset = []
	q = 0
	for i in range(n):
		if mask & (1 << i):
			subset += problems[i]
			q += 1
	if q != k:
		continue
	cnt = Counter(subset)
	if all(2 * v <= q for v in cnt.values()):
		# print(subset)
		ans += 1

print(ans)