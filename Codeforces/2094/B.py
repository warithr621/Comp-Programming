for _ in range(int(input())):
	n, m, l, r = map(int, input().split())
	if m <= r:
		print(0, m)
	else:
		print(r-m, r)