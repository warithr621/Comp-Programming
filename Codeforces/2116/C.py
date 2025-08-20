from math import gcd
from collections import deque, defaultdict

for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	# you can pick two elements and replace a[i] with gcd(a[i], a[j])
	# find min number of ops to make whole thing equal
	# obviously this should be when all elements are gcd(a) I think?
	g = a[0]
	for x in a:
		g = gcd(g, x)
	k = sum(1 for x in a if x == g)
	if k != 0:
		print(n-k) # we alr have the gcd in the arr, so n-k is forced minimum
		continue

	# since we don't have g in the array alr, we have to make it ourselves
	d, q = {}, deque()
	for x in a:
		if x not in d:
			d[x] = 0 # d[i] is the min number of ops to produce i
			# our goal? find d[g]
			q.append(x)
	ans = -1
	while q and ans == -1:
		v = q.popleft()
		cur_d = d[v]
		for x in a:
			# for each element in x, use the op on it with v and update states accordingly
			# this is literally just jank bfs
			temp_g = gcd(v, x)
			if temp_g == g:
				# found our goal GGS
				ans = cur_d+1
				q.clear()
				break
			if temp_g not in d:
				d[temp_g] = cur_d+1
				q.append(temp_g)
			# if temp_g was alr in d, we must have found an optimal dist alr
	print(ans + (n-1))