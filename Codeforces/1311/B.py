# 3:07

for _ in range(int(input())):
	n, m = map(int, input().split())
	a = [*map(int, input().split())] # length n
	p = [*map(int, input().split())] # length m
	pos = [(0 if i+1 not in p else 1) for i in range(n)]
	while True:
		ok = False
		for i in range(n):
			if pos[i] and a[i] > a[i+1]:
				ok = True
				a[i], a[i+1] = a[i+1], a[i]
		if not ok:
			break
	ok = True
	for i in range(n-1):
		ok &= (a[i] <= a[i+1])
	print("YES" if ok else "No")