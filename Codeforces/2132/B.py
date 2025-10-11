for _ in range(int(input())):
	n = int(input())
	a = []
	tf = 11
	while tf <= n and tf <= int(1e18):
		if n % tf == 0:
			a.append(n//tf)
		tf = (tf-1) * 10 + 1
	a.sort()
	print(len(a))
	if len(a) != 0:
		print(*a)