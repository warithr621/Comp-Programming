def zarr(s):
	# z[i] is the longest pfx of s[i:] that is also a pfx of s itself
	# where we set z[0] = len(s) [although this usually is never used i think]
	n = len(s)
	z = [0] * n
	z[0] = len(s)
	l, r = 0, 0
	for i in range(1, n):
		if i <= r:
			z[i] = min(r - i + 1, z[i - l])
		while i + z[i] < n and s[z[i]] == s[i + z[i]]:
			z[i] += 1
		if i + z[i] - 1 > r:
			l, r = i, i + z[i] - 1
	return z

for _ in range(int(input())):
	n, l, r = map(int, input().split()) # for G1, l == r
	k = r # bcz k is better obvi
	s = input()
	z = zarr(s)
	# figure out the optimal splitting of s into l substrings
	# such that length of common prefix is maximized

	# you know the answer is in the interval [0, floor(n/k)]
	# also the prefix must be a prefix of s itself
	# hm, is that helpful?
	ans = 0
	L, R = 1, n // k
	while L <= R:
		M = (L + R) // 2
		# if M is valid, we can split s into at least k substrings
		# such that all start with M
		last, cnt = 0, 1
		for i in range(1, n):
			if cnt == k:
				break
			if z[i] >= M and i >= last + M:
				cnt += 1
				last = i
		if cnt >= k:
			ans = M
			L = M + 1
		else:
			R = M - 1
	print(ans)