def solve():
	#code
	n, m = map(int, input().split())
	r = [*map(int, input().split())]
	# i think we can do in m^2
	# between 0s our intelligence and strength never change
	# so we can make like "segments" between the 0s and do bs
	# this is esp doable because we know the number of 0s (m)
	segs = [[] for _ in range(m+1)]
	zeros = 0
	for x in r:
		if x == 0:
			zeros += 1
		else:
			segs[zeros].append(x) # contains all checks between the 0s
	
	def compute_gains(seg, x):
		# compute the gains for "seg", where x 0s have passed before it
		fint, fstr = [0] * (m+1), [0] * (m+1) # intelligence, strength
		for v in seg:
			if v > 0:
				if v <= m:
					fint[v] += 1
			else:
				if -v <= m:
					fstr[-v] += 1
		pint, pstr = [0] * (m+1), [0] * (m+1) # prefix sums
		for i in range(1, m+1):
			pint[i] = pint[i-1] + fint[i]
			pstr[i] = pstr[i-1] + fstr[i]
		g = [0] * (x+1)
		for i in range(x+1):
			ipassed = pint[i]
			threshold = x - i
			if threshold <= 0:
				spassed = 0
			else:
				if threshold > m:
					threshold = m
				spassed = pstr[threshold]
			g[i] = ipassed + spassed
		return g

	gains_at_zero = compute_gains(segs[0], 0)
	# print(gains_at_zero)
	prev = [-1] * (m+1)
	prev[0] = gains_at_zero[0]
	# print('!', prev)
	for i in range(m):
		next_gains = compute_gains(segs[i+1], i+1)
		# print(next_gains)
		nxt = [-1] * (m+1)
		for j in range(i+1):
			cur = prev[j]
			if cur == -1:
				continue
			vs = cur + next_gains[j]
			if vs > nxt[j]:
				nxt[j] = vs
			vi = cur + next_gains[j+1]
			if vi > nxt[j+1]:
				nxt[j+1] = vi
		prev = nxt
		# print('!', prev)

	print(max(prev))


solve()
