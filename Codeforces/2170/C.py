def solve():
	#code
	n, k = map(int, input().split())
	q = [*map(int, input().split())]
	r = [*map(int, input().split())]
	# choose x,y such that
		# 1 <= y < x <= k
		# q[i] = floor(x/y) for some i
		# r[j] = x mod y for some j
	# remove qi from q and rj from r
	# for given q and r, min option is
		# y = r+1
		# x = y * q + r
	q.sort()
	caps = []
	for monkey in r:
		if k < monkey:
			continue
		c = (k - monkey) // (monkey + 1)
		if c >= 1:
			caps.append(c)
	caps.sort()

	i, j, ans = 0, 0, 0
	while i < len(q) and j < len(caps):
		if q[i] <= caps[j]:
			ans += 1
			i += 1
			j += 1
		else:
			j += 1
	print(ans)


t = int(input())
for quack in range(t):
	solve()