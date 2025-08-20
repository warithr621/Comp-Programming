for _ in range(int(input())):
	x, n, m = map(int, input().split())
	a, b = x, x

	for i in range(n):
		if a == a//2:
			break
		a = a//2
	for i in range(m):
		if a == (a+1)//2:
			break
		a = (a+1)//2

	for i in range(m):
		if b == (b+1)//2:
			break
		b = (b+1)//2
	for i in range(n):
		if b == b//2:
			break
		b = b//2

	print(b,a)