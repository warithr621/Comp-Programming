for _ in range(int(input())):
	a, k = map(int, input().split())
	for i in range(k-1):
		mn = min(int(d) for d in str(a))
		mx = max(int(d) for d in str(a))
		if mn == 0:
			break
		a += mn * mx
	print(a)