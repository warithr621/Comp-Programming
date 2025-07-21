for _ in range(int(input())):
	n, k = map(int, input().split())
	a = list(map(int, input().split()))
	a.sort(reverse=True)
	curS = sum(a)
	if curS <= k:
		print(0)
		continue
	# the optimal pattern should be to decrease a[-1] to some number
	# then set a bunch of big elements equal to it
	pfx = [0 for _ in range(n+1)]
	for i in range(n):
		pfx[i+1] = pfx[i] + a[i]
	# print(pfx)
	L, R = 1, n * a[0] - k # least and most possible no. of ops
	while L < R:
		M = (L + R) // 2
		# can we do this in M ops?
		# first, check if M subtractions work
		if curS - M <= k:
			# print('?', M, True)
			R = M
			continue
		# next, let us check if we can just subtract M-(n+1) times and then assign with n-1 ops
		if M >= n and n * (a[-1] - (M - (n+1))) <= k:
			# print('?', M, True)
			R = M
			continue
		works = False
		# goal is essentially to use M-x subtractions and x reassignments
		for x in range(1, min(n,M)):
			# a[-1] becomes a[-1] - (M-x)
			# then pfx[x] becomes (M-x) * x
			# print('~', x, curS - (M-x) - (pfx[x] - x * (a[-1] - (M-x))))
			if curS - (M-x) - (pfx[x] - x * (a[-1] - (M-x))) <= k:
				works = True
				break
		# case missed on first one: immediate reassignment!
		# can we assign a total of min(M, n-1) times and get the right value?
		works |= curS - (pfx[min(M, n-1)] - a[-1] * min(M, n-1)) <= k
		# print('?', M, works)
		if works:
			R = M
		else:
			L = M + 1

	print(L)