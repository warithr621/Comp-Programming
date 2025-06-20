for _ in range(int(input())):
	n, m = map(int, input().split())
	a = []
	mxval = 0
	for i in range(n):
		a.append(list(map(int, input().split())))
		mxval = max(mxval, max(a[i]))
	mxs = set()
	r = [0 for tmp in range(n)]
	c = [0 for tmp in range(m)]
	for i in range(n):
		for j in range(m):
			if a[i][j] == mxval:
				mxs.add((i,j))
				r[i] += 1
				c[j] += 1
	# print(r, c, mxs)
	works = False
	for i in range(n):
		for j in range(m):
			if r[i] + c[j] - (1 if (i,j) in mxs else 0) == len(mxs):
				works = True
				break
	print(mxval - 1 if works else mxval)
	# print('-' * 20)
