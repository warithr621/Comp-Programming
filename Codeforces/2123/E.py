for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	freq = [0] * (n+1)
	for x in a:
		freq[x] += 1
	ok = [False] * (n+2)
	ok[0] = True
	for i in range(1, n+2):
		ok[i] = ok[i-1] and (freq[i-1] > 0)
	diff = [0] * (n+2)
	for i in range(n+1):
		if ok[i]:
			l, r = freq[i], n-i
			if l <= r:
				diff[l] += 1
				diff[r+1] -= 1
	ans = [0] * (n+1)
	running = 0
	for i in range(n+1):
		running += diff[i]
		ans[i] = running
	print(' '.join(map(str, ans)))