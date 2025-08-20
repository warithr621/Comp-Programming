for _ in range(int(input())):
	n, q = map(int, input().split())
	c = [*map(int, input().split())]
	pfx, ones = [0] * (n+1), [0] * (n+1)
	for i in range(n):
		pfx[i+1] = pfx[i] + c[i]
		ones[i+1] = ones[i] + (c[i] == 1)
	for __ in range(q):
		l, r = map(int, input().split())
		s = pfx[r] - pfx[l-1]
		o = ones[r] - ones[l-1]
		print("Yes" if (r-l+1) + o <= s and r > l else "No")