for _ in range(int(input())):
	n, x, y = map(int, input().split())
	x, y = x-1, y-1
	a = [1 for _ in range(n)]
	for i in range(x, x+n, 2):
		a[i%n] = 0
	if n % 2 == 1 or (x-y) % 2 == 0:
		a[x] = 2
	print(*a)