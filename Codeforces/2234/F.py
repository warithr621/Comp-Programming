def solve():
	n = int(input())
	h = [*map(int, input().split())]
	# make a global max at index 0
	pos = 0
	for i in range(n):
		if h[i] > h[pos]:
			pos = i
	a = h[pos:] + h[:pos]
	d = a[1:]
	m = n - 1
	# before we were consistently having to take prefix and suffix minima and shit
	# if we rotate the array, then min(pfxmax, sfxmax) will just be one of those
	# since the other is guaranteed to have a global element xd

	# we can also do some stack shit to "jump", take advantage of the fact pfx and sfx are be monotonic

	# pfx[i] = sum of maxima of all prefixes
	nxt = [m] * m
	st = []
	for i in range(m - 1, -1, -1):
		while st and d[st[-1]] <= d[i]:
			st.pop()
		nxt[i] = st[-1] if st else m
		st.append(i)
	pfx = [0] * m
	for i in range(m-1, -1, -1):
		j = nxt[i]
		pfx[i] = d[i] * (j-i) + (pfx[j] if j < m else 0)

	pg = [-1] * m # pg[i] = closest element (left of i) s.t. d[pg[i]] > d[i]
	# ^ nxt has a similar role for the pfx sums
	st = []
	for i in range(m):
		while st and d[st[-1]] <= d[i]:
			st.pop()
		pg[i] = st[-1] if st else -1
		st.append(i)
	sfx = [0] * m
	for i in range(m):
		p = pg[i]
		sfx[i] = d[i] * (i-p) + (sfx[p] if p != -1 else 0)

	rotated = [0] * n
	rotated[0] = sfx[m-1]
	for l in range(1, n):
		rotated[l] = pfx[l-1] + (sfx[l-2] if l >= 2 else 0)
	ans = [0] * n
	for i in range(n):
		ans[i] = rotated[(i-pos) % n]
	print(*ans)

t = int(input())
for quack in range(t):
	solve()