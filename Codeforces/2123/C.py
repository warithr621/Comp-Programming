for _ in range(int(input())):
	n = int(input())
	a = [*map(int, input().split())]
	pref, suf = [0] * n, [0] * n
	m = float('inf')
	for i in range(n):
		m = min(m, a[i])
		pref[i] = m
	m = float('-inf')
	for i in range(n-1, -1, -1):
		m = max(m, a[i])
		suf[i] = m
	mn, mx = min(a), max(a)
	ans = []
	for i in range(n):
		x = a[i]
		if x == mn or x == mx:
			ans.append('1')
		elif x == pref[i] or x == suf[i]:
			ans.append('1')
		else:
			ans.append('0')
	print(''.join(ans))